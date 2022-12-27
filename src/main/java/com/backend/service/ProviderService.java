package com.backend.service;

import com.backend.utils.Response;
import com.backend.entity.Provider;
import com.backend.entity.User;
import com.backend.mapper.ProviderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProviderService {
    @Autowired
    private ProviderMapper providerMapper;
    
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
}
