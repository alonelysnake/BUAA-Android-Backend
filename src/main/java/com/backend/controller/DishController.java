package com.backend.controller;

import com.backend.entity.Dish;
import com.backend.service.DishService;
import com.backend.utils.PageBean;
import com.backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    // 添加菜品
    @PostMapping("/insert")
    @ResponseBody
    public Response<Dish> insertDish(@RequestBody Dish dish) {
        return dishService.insertDish(dish);
    }

    // 删除菜品
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Response<Dish> deleteDish(@PathVariable int id) {
        return dishService.deleteDish(id);
    }

    /**
     * 传入 当前页,页大小,菜品id
     * */
    @RequestMapping(value = "/pages/{curPage}/{pageSize}/{p_id}",method = RequestMethod.GET)
    @ResponseBody
    public PageBean<Dish> findDishByProvider(@PathVariable int curPage, @PathVariable int pageSize, @PathVariable int p_id){
        return dishService.findDishByProvider(curPage,pageSize,p_id);
    }

    // 修改菜品折扣
    @PutMapping("/update/discount/{id}/{discount}")
    @ResponseBody
    public Response<Dish> updateDiscount(@PathVariable int id,@PathVariable double discount) {
        return dishService.updateDiscount(id,discount);
    }

    // 修改菜品价格
    @PutMapping("/update/price/{id}/{price}")
    @ResponseBody
    public Response<Dish> updatePrice(@PathVariable int id,@PathVariable double price) {
        return dishService.updatePrice(id,price);
    }

    // 点赞
    @PutMapping("/update/addLike/{id}")
    @ResponseBody
    public Response<Dish> addLike(@PathVariable int id) {
        return dishService.addLike(id);
    }

    // 点踩
    @PutMapping("/update/addDislike/{id}")
    @ResponseBody
    public Response<Dish> addDislike(@PathVariable int id) {
        return dishService.addDislike(id);
    }

    // 取消点赞
    @PutMapping("/update/cancelLike/{id}")
    @ResponseBody
    public Response<Dish> cancelLike(@PathVariable int id) {
        return dishService.cancelLike(id);
    }

    // 取消点踩
    @PutMapping("/update/cancelDislike/{id}")
    @ResponseBody
    public Response<Dish> cancelDislike(@PathVariable int id) {
        return dishService.cancelDislike(id);
    }
}

