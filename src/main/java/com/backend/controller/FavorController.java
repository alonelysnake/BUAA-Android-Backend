package com.backend.controller;

import com.backend.entity.Favor;
import com.backend.service.FavorService;
import com.backend.utils.PageBean;
import com.backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/favor")
public class FavorController {
    @Autowired
    private FavorService service;

    // 添加收藏
    @PostMapping("/insert")
    @ResponseBody
    public Response<Favor> insertFavor(@RequestBody Favor favor) {
        return service.insertFavor(favor);
    }

    // 删除收藏
    @DeleteMapping("/delete")
    @ResponseBody
    public Response<Favor> deleteFavor(@RequestBody Favor favor) {
        return service.deleteFavor(favor);
    }

    /**
     * 传入 当前页,页大小,用户id
     * */
    @RequestMapping(value = "/pages/{curPage}/{pageSize}/{u_id}",method = RequestMethod.GET)
    @ResponseBody
    public PageBean<Favor> findFavorByProvider(@PathVariable int curPage, @PathVariable int pageSize, @PathVariable int u_id){
        return service.findFavorByUser(curPage,pageSize,u_id);
    }
}
