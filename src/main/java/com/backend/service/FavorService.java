package com.backend.service;

import com.backend.entity.Favor;
import com.backend.mapper.FavorMapper;
import com.backend.utils.PageBean;
import com.backend.utils.Response;
import com.github.pagehelper.PageHelper;
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

    public PageBean<Favor> findFavorByUser(Integer currentPage, Integer pageSize, int u_id) {
        PageHelper.startPage(currentPage, pageSize);
        List<Favor> favors = favorMapper.findByUid(u_id);
        int countNums = favorMapper.countFavorByUid(u_id);            //总记录数
        PageBean<Favor> pageBean = new PageBean<>();
        pageBean.setInfo(favors,currentPage,pageSize,countNums);
        return pageBean;
    }
}
