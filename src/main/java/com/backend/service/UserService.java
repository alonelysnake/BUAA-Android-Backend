package com.backend.service;

import com.backend.Response;
import com.backend.entity.User;
import com.backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    
    //用户注册
    public Response<User> register(String name, String password) {
        User user = new User(name, password);
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
    public Response<User> login(String name, String password) {
        Response<User> res = new Response<>();
        try {
            int success = userMapper.countByNameAndPwd(name, password);
            if (success == 0) {
                res.setState(false);
                res.setMsg("用户名不存在或密码错误");
            } else {
                res.setState(true);
                res.setData(userMapper.getUserByName(name));
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
    //重置密码
    public Response<String> resetPassword(int id) {
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
}
