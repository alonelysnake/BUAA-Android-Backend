package com.backend.controller;

import com.backend.utils.PageBean;
import com.backend.utils.Response;
import com.backend.entity.Comment;
import com.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 传入 当前页,页大小,菜品id
     * */
    @RequestMapping(value = "/pages/{curPage}/{pageSize}/{d_id}",method = RequestMethod.GET)
    @ResponseBody
    public PageBean<Comment> findCommentByDish(@PathVariable int curPage,@PathVariable int pageSize,@PathVariable int d_id){
        return commentService.findCommentByDish(curPage,pageSize,d_id);
    }

    @PostMapping("/insert")
    @ResponseBody
    public Response<Comment> insertCom(@RequestBody Comment comment) {
        return commentService.insertCom(comment);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Response<Comment> deleteCom(@PathVariable int id) {
        return commentService.deleteCom(id);
    }
}
