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
        if (success == 0) {
            res.setState(false);
            res.setMsg("发布失败");
        } else {
            res.setState(true);
            res.setMsg("发布成功");
            res.setData(comment);
        }
        return res;
    }

    public Response<Comment> deleteCom(int id) {
        int success = commentMapper.removeById(id);
        Response<Comment> res = new Response<>();
        if (success == 0) {
            res.setState(false);
            res.setMsg("删除失败");
        } else {
            res.setState(true);
            res.setMsg("删除成功");
        }
        return res;
    }

    public PageBean<Comment> findCommentByPage(Integer currentPage, Integer pageSize) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);

        List<Comment> comments = commentMapper.listAll();
        int countNums = commentMapper.countComment();            //总记录数
        PageBean<Comment> pageBean = new PageBean<>();
        pageBean.setItems(comments);//分页结果
        pageBean.setCurrentPage(currentPage);//当前页
        pageBean.setPageSize(pageSize);//设置每页显示条数
        pageBean.setTotalNum(countNums);//设置总条数


        //计算分页数
        int pageCount=(countNums+pageSize-1)/pageSize;
        pageBean.setTotalPage(pageCount);//设置总页数
        if(currentPage<pageCount){
            pageBean.setIsMore(1);
        }else {
            pageBean.setIsMore(0);
        }
        return pageBean;
    }
}
