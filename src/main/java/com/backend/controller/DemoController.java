package com.backend.controller;

import com.backend.entity.Demo;
import com.backend.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//controller 书写规范
@RestController
@RequestMapping("demo"/*路径*/)
public class DemoController {
    @Autowired
    private DemoService demoService;
    
    //前端以url进行数据传输时
    @RequestMapping(path = "/demo1/{para1}"/*路径*/, method = RequestMethod.GET/*根据前端request的种类设置*/)
    @ResponseBody
    public int demo1(@PathVariable("para1"/*若变量名一致则可以省略*/) int para1) {
        return demoService.demo1(para1);
    }
    
    //前端以jsonObject进行数据传输时
    @RequestMapping(path = "/demo2", method = RequestMethod.POST)
    @ResponseBody
    public Demo demo2(@RequestBody Demo para) {
        return demoService.demo2(para);
    }
}
