package com.backend.service;

import com.backend.entity.Favor;
import com.backend.mapper.FavorMapper;
import com.backend.utils.PageBean;
import com.backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavorService {
    @Autowired
    private FavorMapper favorMapper;

    // 添加收藏
    public Response<Favor> insertFavor(Favor favor) {
        Response<Favor> res = new Response<>();
        int success = favorMapper.insert(favor);
        res.setInfo(success,"收藏成功","收藏失败");
        return res;
    }

    // 删除收藏
    public Response<Favor> deleteFavor(Favor favor) {
        int success = favorMapper.removeFavor(favor);
        Response<Favor> res = new Response<>();
        res.setInfo(success,"取消收藏成功","取消收藏失败");
        return res;
    }

    public Response<List<Favor>> findFavorByUser(int u_id) {
        Response<List<Favor>> res = new Response<>();
        try {
            List<Favor> favors = favorMapper.findByUid(u_id);
            if (favors == null) {
                res.setState(false);
                res.setMsg("获取收藏失败");
            } else {
                res.setState(true);
                res.setData(favors);
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
}
