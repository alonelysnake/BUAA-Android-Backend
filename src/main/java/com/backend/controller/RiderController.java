package com.backend.controller;

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
    private UserService userService;
    
    @RequestMapping(path = "/getInfo/{id}")
    public Response<Map<String, Object>> getInfo(@PathVariable int id) {
        return userService.getRiderInfo(id);
    }
    
    //TODO 还应该提供用户名或用户id（不是骑手的）
    @RequestMapping(path = "/changeInfo/{userName}/{contact}/{accountName}/{password}/{realName}/{stuId}/{school}")
    public Response<Boolean> getInfo(@PathVariable String accountName,
                                     @PathVariable String contact,
                                     @PathVariable String password,
                                     @PathVariable String realName,
                                     @PathVariable String school,
                                     @PathVariable String stuId,
                                     @PathVariable String userName) {
        
        return userService.changeRiderInfo(accountName, contact, password, realName, school, stuId, userName);
    }
}
