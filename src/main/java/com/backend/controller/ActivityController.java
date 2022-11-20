package com.backend.controller;

import com.backend.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;


}
