package com.backend.controller;

import com.backend.utils.Response;
import com.backend.entity.Provider;
import com.backend.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.HashSet;

@RestController
@RequestMapping("provider")
public class ProviderController {
    @Autowired
    private ProviderService providerService;
    
    /**
     * 商家注册
     *
     * @param name
     * @param password
     * @param district_id
     * @return 注册成功的商家实体类
     */
    @RequestMapping(path = "/register/{name}/{password}/{district_id}", method = RequestMethod.GET)
    @ResponseBody
    public Response<Provider> register(@PathVariable String name, @PathVariable String password, @PathVariable int district_id) {
        return providerService.register(name, password, district_id);
    }
    
    /**
     * 商家登录
     *
     * @param name
     * @param password
     * @return 登录成功的商家实体类
     */
    @RequestMapping(path = "/login/{name}/{password}", method = RequestMethod.GET)
    @ResponseBody
    public Response<Provider> login(@PathVariable String name, @PathVariable String password) {
        return providerService.login(name, password);
    }
    
    /**
     * 商家重置密码
     * @param id
     * @return 重置初始密码为123456
     */
    @RequestMapping(path = "/reset/{id}")
    public Response<String> reset(@PathVariable int id) {
        return providerService.resetPassword(id);
    }
    
    /**
     * 获取单个商家的全部信息
     * @param id
     * @return
     */
    @RequestMapping(path = "/getInfo/{id}")
    public Response<Provider> getInfo(@PathVariable int id) {
        return providerService.getProviderById(id);
    }
}
