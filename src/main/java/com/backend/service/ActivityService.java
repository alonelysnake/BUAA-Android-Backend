package com.backend.service;

import com.backend.entity.Activity;
import com.backend.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ActivityService {
    @Autowired
    private ActivityMapper mapper;

    public Activity getActivityById(int actId) {
        return mapper.getActivityById(actId);
    }

    public void insertActivity(LocalDateTime start, LocalDateTime end, int adminId) {
        mapper.insertActivity(start,end,adminId);
    }

}
