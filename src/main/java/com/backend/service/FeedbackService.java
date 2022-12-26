package com.backend.service;

import com.backend.utils.Response;
import com.backend.entity.Feedback;
import com.backend.entity.Message;
import com.backend.mapper.FeedbackMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FeedbackService {
    @Autowired
    private FeedbackMapper feedbackMapper;
    
    public Response<String> addFeedback(int uid, String content) {
        Feedback feedback = new Feedback(uid, content);
        Response<String> res = new Response<>();
        try {
            int success = feedbackMapper.insert(feedback);
            if (success == 0) {
                res.setState(false);
                res.setMsg("提交失败");
            } else {
                res.setState(true);
                res.setData("提交成功");
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
    public Response<String> removeFeedback(int fb_id) {
        Response<String> res = new Response<>();
        try {
            int success = feedbackMapper.removeById(fb_id);
            if (success == 0) {
                res.setState(false);
                res.setMsg("删除失败");
            } else {
                res.setState(true);
                res.setData("删除成功");
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
    public Response<List<Feedback>> getFeedbacks(int uid) {
        Response<List<Feedback>> res = new Response<>();
        try {
            List<Feedback> feedbacks = feedbackMapper.listByUserId(uid);
            if (feedbacks == null) {
                res.setState(false);
                res.setMsg("获取反馈失败");
            } else {
                res.setState(true);
                res.setData(feedbacks);
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
}
