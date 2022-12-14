package com.backend.service;

import com.backend.entity.Rider;
import com.backend.entity.User;
import com.backend.mapper.RiderMapper;
import com.backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RiderService {
    @Autowired
    private RiderMapper riderMapper;
    
    public Response<Boolean> register(String id, String name, String password) {
        Response<Boolean> res = new Response<>();
        try {
            int success = riderMapper.insert(id, name, password);
            if (success == 0) {
                res.setState(false);
                res.setMsg("用户名不存在或密码错误");
            } else {
                res.setState(true);
                res.setData(true);
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
    public Response<Boolean> login(String id, String password) {
        Response<Boolean> res = new Response<>();
        try {
            Rider rider = riderMapper.getByIdAndPassword(id, password);
            if (rider == null) {
                res.setState(false);
                res.setMsg("用户名不存在或密码错误");
            } else {
                res.setState(true);
                res.setData(true);
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
    public Response<Map<String, Object>> getRiderInfo(String id) {
        Response<Map<String, Object>> res = new Response<>();
        try {
            Rider rider = riderMapper.getById(id);
            HashMap<String, Object> data = new HashMap<>();
            data.put("userName", rider.getName());
            data.put("contact", rider.getContact());
            data.put("password", rider.getPassword());
            data.put("realName", rider.getRealName());
            data.put("stuId", rider.getId());
            data.put("school", rider.getSchool());
            res.setState(true);
            res.setData(data);
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
    public Response<Boolean> changeInfo(String contact, String password, String realName, String school, String stuId, String userName) {
        int success = riderMapper.updateById(contact, password, realName, school, stuId, userName);
        Response<Boolean> res = new Response<>();
        res.setInfo(success, "修改成功", "修改失败", success == 1);
        return res;
    }
    
    public Response<Integer> getRiderNum() {
        Response<Integer> res = new Response<>();
        res.setState(true);
        res.setData(riderMapper.listAll().size());
        return res;
    }
}
