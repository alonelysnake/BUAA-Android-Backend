package com.backend.controller;

import com.backend.utils.Response;
import com.backend.entity.Activity;
import com.backend.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;

    @PostMapping(path = "/insert")
    @ResponseBody
    public Response<Activity> insertAct(@RequestBody Activity activity) {
        return activityService.insertActivity(activity);
    }
}
