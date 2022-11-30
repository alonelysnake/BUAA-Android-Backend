package com.backend.service;

import com.backend.utils.PageBean;
import com.backend.utils.Response;
import com.backend.entity.Comment;
import com.backend.mapper.CommentMapper;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    @Autowired
    private CommentMapper commentMapper;

    public Response<Comment> insertCom(Comment comment) {
        Response<Comment> res = new Response<>();
        int success = commentMapper.insert(comment);
        res.setInfo(success,"发布成功","发布失败",comment);
        return res;
    }

    public Response<Comment> deleteCom(int id) {
        int success = commentMapper.removeById(id);
        Response<Comment> res = new Response<>();
        res.setInfo(success,"删除成功","删除失败");
        return res;
    }

    public PageBean<Comment> findCommentByDish(Integer currentPage, Integer pageSize, int d_id) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);

        List<Comment> comments = commentMapper.getCommentsByDid(d_id);
        int countNums = commentMapper.countCommentByDid(d_id);            //总记录数
        PageBean<Comment> pageBean = new PageBean<>();
        pageBean.setInfo(comments,currentPage,pageSize,countNums);
        return pageBean;
    }
}
