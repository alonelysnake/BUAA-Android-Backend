package com.backend.service;

import com.backend.utils.Response;
import com.backend.entity.Administrator;
import com.backend.mapper.AdministratorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {
    @Autowired
    private AdministratorMapper adminMapper;

    public Response<Administrator> register(Administrator admin) {
        Response<Administrator> res = new Response<>();
        try {
            int success = adminMapper.insertAdmin(admin);
            res.setInfo(success,"注册成功","用户已注册",admin);
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            res.setMsg("用户名重复");
            e.printStackTrace();
        }
        return res;
    }

    public Response<Administrator> login(String name, String password) {
        Response<Administrator> res = new Response<>();
        try {
            int success = adminMapper.countByNameAndPwd(name, password);
            res.setInfo(success,"登录成功","用户名不存在或密码错误",adminMapper.getAdminByName(name));
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
            int success = adminMapper.updatePasswordForReset(id, initPassword);
            res.setInfo(success,"重置密码成功，初始密码为123456","重置密码失败");
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }

    public Response<Administrator> getAdminById(int id) {
        Response<Administrator> res = new Response<>();
        try {
            Administrator admin = adminMapper.getAdminById(id);
            res.setData(admin);
            res.setState(true);
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }

}
