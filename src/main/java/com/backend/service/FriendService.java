package com.backend.service;

import com.backend.utils.Response;
import com.backend.mapper.FriendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FriendService {
    @Autowired
    private FriendMapper friendMapper;
    
    public Response<String> addFriend(String uid, String fid) {
        Response<String> res = new Response<>();
        try {
            int success = friendMapper.insert(uid, fid);
            if (success == 0) {
                res.setState(false);
                res.setMsg("添加好友失败");
            } else {
                res.setState(true);
                res.setData("添加成功");
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
    public Response<String> remove(String uid, String fid) {
        Response<String> res = new Response<>();
        try {
            int success = friendMapper.remove(uid, fid);
            if (success == 0) {
                res.setState(false);
                res.setMsg("删除好友失败");
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
}
