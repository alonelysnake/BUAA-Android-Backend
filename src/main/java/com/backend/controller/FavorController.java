package com.backend.controller;

import com.backend.entity.Favor;
import com.backend.service.FavorService;
import com.backend.utils.PageBean;
import com.backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @RequestMapping(value = "/select/{u_id}",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<Favor>> findFavorByProvider(@PathVariable int u_id){
        return service.findFavorByUser(u_id);
    }
}
