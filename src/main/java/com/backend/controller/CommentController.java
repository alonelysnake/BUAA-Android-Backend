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

    @RequestMapping(value = "/pages/{curPage}/{pageSize}",method = RequestMethod.GET)
    @ResponseBody
    public PageBean<Comment> commentPage(@PathVariable int curPage,@PathVariable int pageSize){
        return commentService.findCommentByPage(curPage,pageSize);
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
