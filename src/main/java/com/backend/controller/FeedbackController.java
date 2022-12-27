package com.backend.controller;

import com.backend.entity.Feedback;
import com.backend.service.FeedbackService;
import com.backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("feedback")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;
    
    //用户查看自己的反馈
    @RequestMapping("/getUserFeedbacks/{uid}")
    public Response<List<Feedback>> getUserFeedbacks(@PathVariable int uid) {
        return feedbackService.getUserFeedbacks(uid);
    }
    
    //管理员查看自己的反馈
    @RequestMapping("/getAdminFeedbacks/{aid}")
    public Response<List<Feedback>> getAdminFeedbacks(@PathVariable int aid) {
        return feedbackService.getAdminFeedbacks(aid);
    }
    
    //查看所有反馈
    @RequestMapping("/getAll")
    public Response<List<Feedback>> getAll() {
        return feedbackService.getAll();
    }
}
