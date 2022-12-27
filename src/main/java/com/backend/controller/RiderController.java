package com.backend.controller;

import com.backend.service.RiderService;
import com.backend.service.UserService;
import com.backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("rider")
public class RiderController {
    @Autowired
    private RiderService riderService;
    
    //TODO 创建骑手（待认证）
    
    
    //获取骑手信息
    @RequestMapping(path = "/getInfo/{id}")
    public Response<Map<String, Object>> getInfo(@PathVariable int id) {
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
}
