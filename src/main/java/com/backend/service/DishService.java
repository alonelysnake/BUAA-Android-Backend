package com.backend.service;

import com.backend.entity.Dish;
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

    public Response<List<Dish>> getDishBySpeech(String pinyin) {
        Response<List<Dish>> res = new Response<>();
        try {
            List<Dish> dishes = dishMapper.findByPinyin(pinyin);
            if (dishes == null) {
                res.setState(false);
                res.setMsg("获取菜品失败");
            } else {
                res.setState(true);
                res.setData(dishes);
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
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

    public PageBean<Dish> findDishByName(Integer currentPage, Integer pageSize, String name) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);
        List<Dish> dishes = dishMapper.findByName(name);
        int countNums = dishMapper.countDishByName(name);            //总记录数
        PageBean<Dish> pageBean = new PageBean<>();
        pageBean.setInfo(dishes,currentPage,pageSize,countNums);
        return pageBean;
    }

    public PageBean<Dish> findDishByPrice(Integer currentPage, Integer pageSize, double from,double to) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);
        List<Dish> dishes = dishMapper.findByPrice(from,to);
        int countNums = dishMapper.countDishByPrice(from,to);            //总记录数
        PageBean<Dish> pageBean = new PageBean<>();
        pageBean.setInfo(dishes,currentPage,pageSize,countNums);
        return pageBean;
    }

    public PageBean<Dish> findDishByLowestPrice(Integer currentPage, Integer pageSize, double to) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);
        List<Dish> dishes = dishMapper.findByLowestPrice(to);
        int countNums = dishMapper.countDishByLowestPrice(to);            //总记录数
        PageBean<Dish> pageBean = new PageBean<>();
        pageBean.setInfo(dishes,currentPage,pageSize,countNums);
        return pageBean;
    }

    public PageBean<Dish> findDishByHighestPrice(Integer currentPage, Integer pageSize, double to) {
        //设置分页信息，分别是当前页数和每页显示的总记录数【记住：必须在mapper接口中的方法执行之前设置该分页信息】
        PageHelper.startPage(currentPage, pageSize);
        List<Dish> dishes = dishMapper.findByHighestPrice(to);
        int countNums = dishMapper.countDishByHighestPrice(to);            //总记录数
        PageBean<Dish> pageBean = new PageBean<>();
        pageBean.setInfo(dishes,currentPage,pageSize,countNums);
        return pageBean;
    }

    public Response<Dish> updateDish(Dish dish) {
        int success = dishMapper.updateDish(dish);
        Response<Dish> res = new Response<>();
        res.setInfo(success,"修改商品成功","修改商品失败");
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
