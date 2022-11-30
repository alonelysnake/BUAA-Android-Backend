package com.backend.service;

import com.backend.entity.Dish;
import com.backend.mapper.DishMapper;
import com.backend.utils.PageBean;
import com.backend.utils.Response;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {
    @Autowired
    private DishMapper dishMapper;
    
    // 添加菜品
    public Response<Dish> insertDish(Dish dish) {
        Response<Dish> res = new Response<>();
        int success = dishMapper.insert(dish);
        res.setInfo(success,"添加菜品成功","添加菜品失败");
        return res;
    }
    
    // 删除菜品
    public Response<Dish> deleteDish(int id) {
        int success = dishMapper.removeById(id);
        Response<Dish> res = new Response<>();
        res.setInfo(success,"删除菜品成功","删除菜品失败");
        return res;
    }

    public PageBean<Dish> findDishByProvider(Integer currentPage, Integer pageSize, int p_id) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);
        List<Dish> dishes = dishMapper.findByPid(p_id);
        int countNums = dishMapper.countDishByPid(p_id);            //总记录数
        PageBean<Dish> pageBean = new PageBean<>();
        pageBean.setInfo(dishes,currentPage,pageSize,countNums);
        return pageBean;
    }

    public Response<Dish> updateDiscount(int id,double discount) {
        int success = dishMapper.updateDiscount(id,discount);
        Response<Dish> res = new Response<>();
        res.setInfo(success,"修改折扣成功","修改折扣失败");
        return res;
    }

    public Response<Dish> updatePrice(int id,double price) {
        int success = dishMapper.updatePrice(id,price);
        Response<Dish> res = new Response<>();
        res.setInfo(success,"修改价格成功","修改价格失败");
        return res;
    }

    public Response<Dish> addLike(int id) {
        int success = dishMapper.addLike(id);
        Response<Dish> res = new Response<>();
        res.setInfo(success,"点赞成功","点赞失败");
        return res;
    }

    public Response<Dish> addDislike(int id) {
        int success = dishMapper.addDislike(id);
        Response<Dish> res = new Response<>();
        res.setInfo(success,"点踩成功","点踩失败");
        return res;
    }

    public Response<Dish> cancelLike(int id) {
        int success = dishMapper.cancelLike(id);
        Response<Dish> res = new Response<>();
        res.setInfo(success,"取消点赞成功","取消点赞失败");
        return res;
    }

    public Response<Dish> cancelDislike(int id) {
        int success = dishMapper.cancelDislike(id);
        Response<Dish> res = new Response<>();
        res.setInfo(success,"取消点踩成功","取消点踩失败");
        return res;
    }
}
