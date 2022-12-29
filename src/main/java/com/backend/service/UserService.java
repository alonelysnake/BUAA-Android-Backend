package com.backend.service;

import com.backend.utils.Response;
import com.backend.entity.User;
import com.backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    
    //用户注册
    public Response<User> register(String id, String name, String password) {
        User user = new User(id, name, password);
        Response<User> res = new Response<>();
        try {
            int success = userMapper.insert(user);
            if (success == 0) {
                res.setState(false);
                res.setMsg("用户已注册");
            } else {
                res.setState(true);
                res.setData(user);
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            //TODO 数据库设置了unique约束，实际此处为重复用户
            res.setMsg("用户名重复");
            e.printStackTrace();
        }
        return res;
    }
    
    //用户登录
    public Response<User> login(String id, String password) {
        System.out.println(id);
        System.out.println(password);
        Response<User> res = new Response<>();
        try {
            int success = userMapper.countByIdAndPwd(id, password);
            if (success == 0) {
                res.setState(false);
                res.setMsg("用户名不存在或密码错误");
            } else {
                res.setState(true);
                res.setData(userMapper.getUserById(id));
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
    public Response<User> updateUserInfo(User user) {
        Response<User> res = new Response<>();
        try {
            int success = userMapper.updateInfo(user);
            if (success == 0) {
                res.setState(false);
                res.setMsg("修改失败");
            } else {
                res.setState(true);
                res.setData(user);
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
            int success = userMapper.updatePasswordForReset(id, initPassword);
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
    
    //获取用户数
    public Response<Integer> getUserNum() {
        Response<Integer> res = new Response<>();
        res.setState(true);
        res.setData(userMapper.listAll().size());
        return res;
    }
    
    // 根据用户id得到用户个人信息
    public Response<HashMap<String, Object>> getInfoById(String id) {
        Response<HashMap<String, Object>> res = new Response<>();
        try {
            System.out.println(id);
            User user = userMapper.getUserById(id);
            HashMap<String, Object> map = new HashMap<>();
            map.put("name", user.getName());
            map.put("contact", user.getPhone());
            map.put("address", user.getAddress());
            map.put("password", user.getPassword());
            res.setData(map);
            res.setState(true);
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        System.out.println(res.getData());
        return res;
    }
    
    //得到所有未认证的骑手
    public Response<List<User>> getUncertainRider() {
        Response<List<User>> res = new Response<>();
        res.setData(userMapper.listUncertainRider());
        return res;
    }
    
    //得到所有未认证的贫困生
    public Response<List<User>> getUncertainPoor() {
        Response<List<User>> res = new Response<>();
        res.setData(userMapper.listUncertainPoor());
        return res;
    }
}
