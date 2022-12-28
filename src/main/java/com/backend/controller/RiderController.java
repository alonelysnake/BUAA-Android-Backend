package com.backend.controller;

import com.backend.entity.User;
import com.backend.service.RiderService;
import com.backend.service.UserService;
import com.backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("rider")
public class RiderController {
    @Autowired
    private RiderService riderService;
    
    //TODO 创建骑手（待认证）
//    @ResponseBody
//    public Response<Boolean> register(@PathVariable String id, @PathVariable String name, @PathVariable String password) {
//        return userServive.register(id, name, password);
//    }
    
    @RequestMapping(path = "/login/{id}/{password}", method = RequestMethod.GET)
    @ResponseBody
    public Response<Boolean> login(@PathVariable String id, @PathVariable String password) {
        return riderService.login(id, password);
    }
    
    
    
    //获取骑手信息
    @RequestMapping(path = "/getInfo/{id}")
    public Response<Map<String, Object>> getInfo(@PathVariable String id) {
        return riderService.getRiderInfo(id);
    }
    
    //修改骑手信息
    @RequestMapping(path = "/changeInfo/{userName}/{contact}/{password}/{realName}/{stuId}/{school}")
    public Response<Boolean> getInfo(@PathVariable String contact,
                                     @PathVariable String password,
                                     @PathVariable String realName,
                                     @PathVariable String school,
                                     @PathVariable String stuId,
                                     @PathVariable String userName) {
        
        return riderService.changeInfo(contact, password, realName, school, stuId, userName);
    }
    
    //骑手数量
    @RequestMapping(path = "/getRiderNum")
    public Response<Integer> getRiderNum() {
        return riderService.getRiderNum();
    }
}
