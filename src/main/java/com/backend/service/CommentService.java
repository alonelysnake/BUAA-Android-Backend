package com.backend.service;

import com.backend.entity.Feedback;
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

    public Response<List<Comment>> findCommentByDish(int d_id) {
        Response<List<Comment>> res = new Response<>();
        try {
            List<Comment> comments = commentMapper.getCommentsByDid(d_id);
            if (comments == null) {
                res.setState(false);
                res.setMsg("获取评论失败");
            } else {
                res.setState(true);
                res.setData(comments);
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
}
