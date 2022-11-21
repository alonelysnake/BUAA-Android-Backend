package com.backend.controller;

import com.backend.Response;
import com.backend.entity.User;
import com.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userServive;
    
    @RequestMapping(path = "/register/{name}/{password}", method = RequestMethod.GET)
    @ResponseBody
    public Response<User> register(@PathVariable String name, @PathVariable String password) {
        return userServive.register(name, password);
    }
    
    @RequestMapping(path = "/login/{name}/{password}", method = RequestMethod.GET)
    @ResponseBody
    public Response<User> login(@PathVariable String name, @PathVariable String password) {
        return userServive.login(name, password);
    }
    
    @RequestMapping(path = "/reset/{id}")
    public Response<String> reset(@PathVariable int id) {
        return userServive.resetPassword(id);
    }
    
    //TODO 用户详细信息查询
}
