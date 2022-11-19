package com.backend.service;

import com.backend.entity.Demo;
import com.backend.mapper.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DemoService {
    @Autowired
    private DemoMapper mapper;
    
    // 此处进行实际处理和sql函数调用
    public int demo1(int para) {
        Demo demo = mapper.getDemo(para, "");
        return demo.getId();
    }
    
    public Demo demo2(Demo para) {
        List<Integer> res = mapper.getDemo2(para);
        return mapper.getDemo(res.get(0), "");
    }
}
