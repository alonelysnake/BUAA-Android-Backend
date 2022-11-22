package com.backend;

import com.backend.entity.Activity;
import com.backend.mapper.ActivityMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class DemoApplicationTests {
    
    @Autowired
    private ActivityMapper activityMapper;

    @Test
    void testGet() {
        Activity activity = activityMapper.getActivityById(4);
        System.out.println(activity);
    }

    @Test
    void testInsert() {
        // activityMapper.insertActivity(LocalDateTime.now(),LocalDateTime.now(),1);
    }

}
