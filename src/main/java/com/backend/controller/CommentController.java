package com.backend.controller;

import com.backend.utils.PageBean;
import com.backend.utils.Response;
import com.backend.entity.Comment;
import com.backend.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;

    /**
     * 菜品id
     * */
    @RequestMapping(value = "/select/{d_id}",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<Comment>> findCommentByDish(@PathVariable int d_id){
        return commentService.findCommentByDish(d_id);
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
