package com.backend.controller;

import com.backend.entity.Dish;
import com.backend.entity.DishIndent;
import com.backend.entity.Indent;
import com.backend.service.DishIndentService;
import com.backend.service.DishService;
import com.backend.service.IndentService;
import com.backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("indent")
public class IndentController {
    @Autowired
    private IndentService indentService;
    @Autowired
    private DishIndentService dishIndentService;
    @Autowired
    private DishService dishService;
    
    //按照条件筛选订单，要求state为状态的字符串形式，分为：
    /*
    paid:已支付（等待商家接单）
    not_accept商家已接单（商家未完成）
    accepted:已完成（等待骑手接单）
    delivering:骑手已接单
    finished:骑手已完成
    canceled:用户已取消
     */
    @RequestMapping(path = "/getUserIndent/{id}/{state}")
    public Response<List<Indent>> getUserIndent(@PathVariable String id, @PathVariable String state) {
        return indentService.getUserIndents(id, Indent.OrderState.valueOf(state.toUpperCase()));
    }
    
    //TODO 查看单个订单的详细信息（统一Response?）
    @RequestMapping(path = "/getInfo/{id}")
    public Response<Map<String, Object>> getInfo(@PathVariable int id) {
        Response<Map<String, Object>> res = new Response<>();
        Response<Indent> indentResponse = indentService.getIndentInfo(id);
        if (!indentResponse.getState()) {
            res.setState(false);
            res.setMsg("获取订单基本信息（除菜品外的）失败");
        } else {
            Map<String, Object> map = new HashMap<>();
            map.put("info", indentResponse.getData());//info:基本信息 dishes:点的所有菜
            //TODO DishIndentService调用方法
            try {
                List<DishIndent> dishIndents = dishIndentService.findByOid(id);
                List<HashMap<String, Integer>> dishes = new ArrayList<>();
                for (DishIndent dishIndent : dishIndents) {
                    HashMap<String, Integer> dish = new HashMap<>();
                    dish.put("dish_id", dishIndent.getDishId());
                    dish.put("num", dishIndent.getSum());
                    dishes.add(dish);
                }
                map.put("dishes", dishes);//所有菜品信息list，包含{dish_id:菜的id,num:点的数量}
            } catch (Exception e) {
                res.setState(false);
                res.setMsg("获取订单菜品信息失败");
            }
        }
        
        return res;
    }
    
    //创建订单
    @PostMapping(path = "/addIndent")
    public Response<String> addIndent(@RequestBody Map<String, Object> params) {
//        LocalDateTime time = (LocalDateTime) params.get("time");
        LocalDateTime time = LocalDateTime.now();
        //TODO 得到其他参数
        double cost = (double) params.get("");
        String address = (String) params.get("");
        int uid = (int) params.get("");
        int rider = (int) params.get("");
        int pid = (int) params.get("");
        Indent indent = new Indent(time, cost, address, uid, rider, pid);
        
        //添加订单
        indentService.addIndent(indent);
        
        //所有菜的id和个数
        Map<Integer, Integer> dishes = (Map<Integer, Integer>) params.get("");
        //TODO 调用Dish中的方法增加订购数
        for (Integer dishId : dishes.keySet()) {
            int dishNum = dishes.get(dishId);
            DishIndent newDishIndent = new DishIndent(indent.getId(), dishId, dishNum);
            dishIndentService.insertDish(newDishIndent);
            //TODO 增加订购数？
            //dishService
        }
        
        Response<String> res = new Response<>();
        res.setData("订单发送成功");
        res.setState(true);
        
        return res;
    }
    
    //商家或骑手更新订单状态
    @PostMapping(path = "/nextState/{id}/{oldState}")
    public Response<Boolean> changeState(@PathVariable int id, @PathVariable String oldState) {
        Indent.OrderState old = Indent.OrderState.valueOf(oldState);
        Indent.OrderState newState;
        if (old.equals(Indent.OrderState.PAID)) {
            newState = Indent.OrderState.NOT_ACCEPT;
        } else if (old.equals(Indent.OrderState.NOT_ACCEPT)) {
            newState = Indent.OrderState.ACCEPTED;
        } else if (old.equals(Indent.OrderState.ACCEPTED)) {
            newState = Indent.OrderState.DELIVERING;
        } else if (old.equals(Indent.OrderState.DELIVERING)) {
            newState = Indent.OrderState.FINISHED;
        } else {
            Response<Boolean> res = new Response<>();
            res.setInfo(0, "", "对已取消或已完成订单操作", false);
            return res;
        }
        return indentService.changeState(id, newState);
    }
    
    //用户取消订单
    @PostMapping(path = "/cancel/{id}")
    public Response<Boolean> cancel(@PathVariable int id) {
        return indentService.changeState(id, Indent.OrderState.CANCELED);
    }
}
