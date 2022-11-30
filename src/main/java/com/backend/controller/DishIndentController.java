package com.backend.controller;

import com.backend.entity.DishIndent;
import com.backend.service.DishIndentService;
import com.backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dishIndent")
public class DishIndentController {
    @Autowired
    private DishIndentService service;

    // 添加菜品
    @PostMapping("/insert")
    @ResponseBody
    public Response<DishIndent> insertDish(@RequestBody DishIndent dishIndent) {
        return service.insertDish(dishIndent);
    }

    @RequestMapping(value = "/select/{o_id}",method = RequestMethod.GET)
    @ResponseBody
    public List<DishIndent> findDishByOrder(@PathVariable int o_id) {
        return service.findByOid(o_id);
    }
}
