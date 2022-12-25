package com.backend.controller;

import com.backend.utils.Response;
import com.backend.entity.Administrator;
import com.backend.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("admin")
public class AdministratorController {
    @Autowired
    private AdministratorService adminServive;

    @PostMapping(path = "/register")
    public Response<Administrator> register(@RequestBody Administrator admin) {
        return adminServive.register(admin);
    }

    @RequestMapping(path = "/login/{name}/{password}", method = RequestMethod.GET)
    @ResponseBody
    public Response<Administrator> login(@PathVariable String name, @PathVariable String password) {
        return adminServive.login(name, password);
    }

    @RequestMapping(path = "/reset/{id}")
    public Response<String> reset(@PathVariable int id) {
        return adminServive.resetPassword(id);
    }

    @RequestMapping(path = "/getInfo/{id}")
    public Response<Administrator> getAdminById(@PathVariable int id) {
        return adminServive.getAdminById(id);
    }

}
