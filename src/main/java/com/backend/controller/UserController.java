package com.backend.controller;

import com.backend.service.FriendService;
import com.backend.utils.Response;
import com.backend.entity.User;
import com.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userServive;
    @Autowired
    private FriendService friendService;
    
    @RequestMapping(path = "/register/{id}//{password}", method = RequestMethod.GET)
    @ResponseBody
    public Response<User> register(@PathVariable String id, @PathVariable String password) {
        String name = "user" + id;
        return userServive.register(id, name, password);
    }
    
    @RequestMapping(path = "/login/{id}/{password}", method = RequestMethod.GET)
    @ResponseBody
    public Response<User> login(@PathVariable String id, @PathVariable String password) {
        return userServive.login(id, password);
    }
    
    @RequestMapping(path = "/reset/{id}")
    public Response<String> reset(@PathVariable String id) {
        return userServive.resetPassword(id);
    }
    
    //TODO 未完成，用户详细信息查询
//    @RequestMapping(path = "/getInfo/{id}")
//    public Response<User> getInfo(@PathVariable String id) {
//        return userServive.getInfoById(id);
//    }
    
    // 添加好友
    @RequestMapping(path = "/getInfo/{uid}/{fid}")
    public Response<String> addFriend(@PathVariable String uid, @PathVariable String fid) {
        return friendService.addFriend(uid, fid);
    }
    
    //得到用户数量
    @RequestMapping(path = "/getUserNum")
    public Response<Integer> getUserNum() {
        System.out.println("调用user/getUserNum");
        return userServive.getUserNum();
    }
    
    @PostMapping(path = "/updateInfo/{uid}")
    @ResponseBody
    public Response<User> updateInfo(@PathVariable String uid, @RequestBody Map<String, Object> params) {
        String name = (String) params.get("name");
        String phone = (String) params.get("contact");
        String address = (String) params.get("address");
        // String email = (String) params.get("email");
        String password = (String) params.get("u_pw");
        User user = new User(uid, name, password, phone, address);
        return userServive.updateUserInfo(user);
    }
    //TODO 用户信息补全
}
