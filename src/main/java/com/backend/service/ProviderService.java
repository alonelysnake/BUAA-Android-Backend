package com.backend.service;

import com.backend.entity.Indent;
import com.backend.mapper.DishMapper;
import com.backend.mapper.IndentMapper;
import com.backend.utils.Response;
import com.backend.entity.Provider;
import com.backend.entity.User;
import com.backend.mapper.ProviderMapper;
import com.backend.utils.RunPython;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service
public class ProviderService {
    @Autowired
    private ProviderMapper providerMapper;
    @Autowired
    private IndentMapper indentMapper;
    @Autowired
    private DishMapper dishMapper;
    
    //用户注册
    public Response<Provider> register(String id, String name, String password, int district) {
        Provider provider = new Provider(id, name, password, district);
        Response<Provider> res = new Response<>();
        try {
            int success = providerMapper.insert(provider);
            if (success == 0) {
                res.setState(false);
                res.setMsg("商家已注册");
            } else {
                res.setState(true);
                res.setData(provider);
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            //TODO 数据库设置了unique约束，实际此处为重复用户
            res.setMsg("商家名重复");
            e.printStackTrace();
        }
        return res;
    }
    
    //用户登录
    public Response<Provider> login(String name, String password) {
        Response<Provider> res = new Response<>();
        try {
            int success = providerMapper.countByIdAndPwd(name, password);
            if (success == 0) {
                res.setState(false);
                res.setMsg("商家名不存在或密码错误");
            } else {
                res.setState(true);
                res.setData(providerMapper.getProviderByName(name));
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
    //重置密码
    public Response<String> resetPassword(String id) {
        Response<String> res = new Response<>();
        final String initPassword = "123456";//TODO 初始密码设置?
        try {
            int success = providerMapper.updatePasswordForReset(id, initPassword);
            if (success == 0) {
                res.setState(false);
                res.setMsg("重置密码失败");
            } else {
                res.setState(true);
                res.setData("重置密码成功，初始密码为123456");
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
    /**
     * 只得到Provider实体表中的信息
     *
     * @param id
     * @return
     */
    public Response<Provider> getProviderById(String id) {
        Response<Provider> res = new Response<>();
        try {
            Provider provider = providerMapper.getProviderById(id);
            res.setData(provider);
            res.setState(true);
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
    public Response<Integer> getProviderNum() {
        Response<Integer> res = new Response<>();
        res.setState(true);
        res.setData(providerMapper.listAll().size());
        return res;
    }
    
    public Response<List<HashMap<String, Object>>> getProfit(@PathVariable String id) {
        Response<List<HashMap<String, Object>>> res = new Response<>();
        try {
            LocalDate baseTime = LocalDate.now().minusDays(7);
            List<Indent> indents = indentMapper.listByProviderAndState(id, Indent.OrderState.FINISHED);
            List<HashMap<String, Object>> costs = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                double cost = 0;
                HashMap<String, Object> oneDay = new HashMap<>();
                LocalDate date1 = baseTime.plusDays(i);
                LocalDate date2 = baseTime.plusDays(i + 1);
                oneDay.put("date", date1);
                for (Indent indent : indents) {
                    if (indent.getTime().toLocalDate().isAfter(date1) && indent.getTime().toLocalDate().isBefore(date2)) {
                        cost += indent.getCost();
                    }
                }
                oneDay.put("money", cost);
                costs.add(oneDay);
            }
            res.setData(costs);
            res.setState(true);
        } catch (Exception e) {
            e.printStackTrace();
            res.setState(false);
        }
        return res;
    }
    
    public Response<List<HashMap<String, Object>>> getOrderNum(@PathVariable String id) {
        Response<List<HashMap<String, Object>>> res = new Response<>();
        try {
            LocalDate baseTime = LocalDate.now().minusDays(7);
            List<Indent> indents = indentMapper.listByProviderAndState(id, Indent.OrderState.FINISHED);
            List<HashMap<String, Object>> costs = new ArrayList<>();
            for (int i = 0; i < 7; i++) {
                int num = 0;
                HashMap<String, Object> oneDay = new HashMap<>();
                LocalDate date1 = baseTime.plusDays(i);
                LocalDate date2 = baseTime.plusDays(i + 1);
                oneDay.put("date", date1);
                for (Indent indent : indents) {
                    if (indent.getTime().toLocalDate().isAfter(date1) && indent.getTime().toLocalDate().isBefore(date2)) {
                        num++;
                    }
                }
                oneDay.put("num", num);//订单数
                costs.add(oneDay);
            }
            res.setData(costs);
            res.setState(true);
        } catch (Exception e) {
            e.printStackTrace();
            res.setState(false);
        }
        return res;
    }
    
    //返回所有菜的预测销量
    public Response<List<HashMap<String, Object>>> getPredicts(@PathVariable String id) {
        Response<List<HashMap<String, Object>>> res = new Response<>();
        try {
            List<HashMap<String, Object>> dishes = dishMapper.listDishById(id);
            
            for (HashMap<String, Object> dish : dishes) {
                int d_id = (int) dish.get("d_id");
                
                LocalDateTime now = LocalDateTime.now();
                StringBuilder args = new StringBuilder();
                for (int i = 30; i > 0; i--) {
                    LocalDateTime time1 = now.minusDays(i);
                    LocalDateTime time2 = now.minusDays(i - 1);
                    Integer num = indentMapper.getDishNumByDate(d_id, time1, time2);
                    if (num == num) {
                        num = 0;
                    }
                    args.append(time1.toLocalDate());
                    args.append(" ");
                    args.append(num);
                    args.append(" ");
                }
                
                args = new StringBuilder();
                for (int i = 30; i > 0; i--) {
                    LocalDateTime time1 = now.minusDays(i);
                    Random random = new Random();
                    int num = random.nextInt(100) + 10;
                    
                    args.append(time1.toLocalDate());
                    args.append(" ");
                    args.append(num);
                    args.append(" ");
                }
                
                int predict = RunPython.runSale("", "", args.toString());
                dish.put("predict", predict);
            }
            res.setData(dishes);
            res.setState(true);
        } catch (Exception e) {
            e.printStackTrace();
            res.setState(false);
        }
        return res;
    }
}
