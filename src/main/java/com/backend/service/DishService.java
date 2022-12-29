package com.backend.service;

import com.backend.entity.Dish;
import com.backend.mapper.DishMapper;
import com.backend.utils.PageBean;
import com.backend.utils.Response;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DishService {
    @Autowired
    private DishMapper dishMapper;
    
    // 添加菜品
    public Response<Dish> insertDish(Dish dish) {
        Response<Dish> res = new Response<>();
        int success = dishMapper.insert(dish);
        res.setInfo(success, "添加菜品成功", "添加菜品失败");
        return res;
    }

    public Response<Double> getTotalCost(ArrayList<Integer> ids) {
        Response<Double> res = new Response<>();
        List<Dish> dishes = findDishByIds(ids).getData();
        double cost = 0;
        for (Dish dish:dishes) {
            cost += dish.getCurPrice();
        }
        res.setState(true);
        res.setMsg("成功");
        res.setData(cost);
        return res;
    }

    public Response<List<Dish>> findDishByIds(ArrayList<Integer> ids) {
        Response<List<Dish>> res = new Response<>();
        List<Dish> dishes = new ArrayList<>();
        for (int id:ids) {
            try {
                Dish dish = dishMapper.findDishById(id);
                dishes.add(dish);
            } catch (Exception ignored) {
            }
        }
        res.setState(true);
        res.setMsg("成功");
        res.setData(dishes);
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

    public Response<List<Dish>> findDishByProvider(int p_id) {
        Response<List<Dish>> res = new Response<>();
        try {
            List<Dish> dishes = dishMapper.findByPid(p_id);
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

    public Response<List<Dish>> findDishByName(String name) {
        Response<List<Dish>> res = new Response<>();
        try {
            List<Dish> dishes = dishMapper.findByName(name);
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

    public Response<List<Dish>> findDishByPrice(double from,double to) {
        Response<List<Dish>> res = new Response<>();
        try {
            List<Dish> dishes = dishMapper.findByPrice(from,to);
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

    public Response<List<Dish>> findDishByLowestPrice(double from) {
        Response<List<Dish>> res = new Response<>();
        try {
            List<Dish> dishes = dishMapper.findByLowestPrice(from);
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

    public Response<List<Dish>> findDishByHighestPrice(double to) {
        Response<List<Dish>> res = new Response<>();
        try {
            List<Dish> dishes = dishMapper.findByHighestPrice(to);
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

    public Response<Dish> updateDish(Dish dish) {
        int success = dishMapper.updateDish(dish);
        Response<Dish> res = new Response<>();
        res.setInfo(success, "修改商品成功", "修改商品失败");
        return res;
    }

    public Response<Integer> updateDishSales(int id, int num) {
        int success = dishMapper.updateDishSale(id, num);
        Response<Integer> res = new Response<>();
        res.setInfo(success, "修改商品成功", "修改商品失败");
        return res;
    }

    public Response<Dish> updatePrice(int id, double price) {
        int success = dishMapper.updatePrice(id, price);
        Response<Dish> res = new Response<>();
        res.setInfo(success, "修改价格成功", "修改价格失败");
        return res;
    }

    public Response<Dish> addLike(int id) {
        int success = dishMapper.addLike(id);
        Response<Dish> res = new Response<>();
        res.setInfo(success, "点赞成功", "点赞失败");
        return res;
    }

    public Response<Dish> addDislike(int id) {
        int success = dishMapper.addDislike(id);
        Response<Dish> res = new Response<>();
        res.setInfo(success, "点踩成功", "点踩失败");
        return res;
    }

    public Response<Dish> cancelLike(int id) {
        int success = dishMapper.cancelLike(id);
        Response<Dish> res = new Response<>();
        res.setInfo(success, "取消点赞成功", "取消点赞失败");
        return res;
    }

    public Response<Dish> cancelDislike(int id) {
        int success = dishMapper.cancelDislike(id);
        Response<Dish> res = new Response<>();
        res.setInfo(success, "取消点踩成功", "取消点踩失败");
        return res;
    }
}
