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
            if (success == 0) {
                res.setState(false);
                res.setMsg("用户已注册");
            } else {
                res.setState(true);
                res.setData(admin);
            }
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
            if (success == 0) {
                res.setState(false);
                res.setMsg("用户名不存在或密码错误");
            } else {
                res.setState(true);
                res.setData(adminMapper.getAdminByName(name));
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
            int success = adminMapper.updatePasswordForReset(id, initPassword);
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
