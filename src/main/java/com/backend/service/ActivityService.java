package com.backend.service;

import com.backend.utils.Response;
import com.backend.entity.Activity;
import com.backend.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {
    @Autowired
    private ActivityMapper mapper;

    public Activity getActivityById(int actId) {
        return mapper.getActivityById(actId);
    }

    // 添加活动
    public Response<Activity> insertActivity(Activity activity) {
        Response<Activity> res = new Response<>();
        try {
            int success = mapper.insertActivity(activity);
            res.setInfo(success,"添加活动成功","添加活动失败",activity);
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }

}
