package com.backend.controller;

import com.backend.entity.Dish;
import com.backend.entity.Indent;
import com.backend.service.DishService;
import com.backend.utils.ChangeChinesePinyin;
import com.backend.utils.PageBean;
import com.backend.utils.Response;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.backend.utils.ChangeChinesePinyin.changeChinesePinyin;

@RestController
@RequestMapping("/dish")
public class DishController {
    @Autowired
    private DishService dishService;

    // 添加菜品
    @PostMapping("/insert")
    @ResponseBody
    public Response<Dish> insertDish(@RequestBody Dish dish) throws BadHanyuPinyinOutputFormatCombination {
        dish.setPinyin(changeChinesePinyin(dish.getName()).get("fullPinyin"));
        return dishService.insertDish(dish);
    }

    @RequestMapping(value = "/getDishBySpeech/{pinyin}",method = RequestMethod.GET)
    public Response<List<Dish>> getUserIndent(@PathVariable String pinyin) {
        return dishService.getDishBySpeech(pinyin);
    }

    // 删除菜品
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Response<Dish> deleteDish(@PathVariable int id) {
        return dishService.deleteDish(id);
    }

    /**
     * 传入 当前页,页大小,商家id
     * */
    @RequestMapping(value = "/pages_id/{curPage}/{pageSize}/{p_id}",method = RequestMethod.GET)
    @ResponseBody
    public PageBean<Dish> findDishByProvider(@PathVariable int curPage, @PathVariable int pageSize, @PathVariable int p_id){
        return dishService.findDishByProvider(curPage,pageSize,p_id);
    }

    /**
     * 传入 当前页,页大小,商品名字
     * */
    @RequestMapping(value = "/pages_name/{curPage}/{pageSize}/{name}",method = RequestMethod.GET)
    @ResponseBody
    public PageBean<Dish> findDishByName(@PathVariable int curPage, @PathVariable int pageSize, @PathVariable String name){
        return dishService.findDishByName(curPage,pageSize,name);
    }

    /**
     * 传入 当前页,页大小,商品最低价，商品最高价
     * */
    @RequestMapping(value = "/pages_price/{curPage}/{pageSize}/{from}/{to}",method = RequestMethod.GET)
    @ResponseBody
    public PageBean<Dish> findDishByPrice(@PathVariable int curPage, @PathVariable int pageSize, @PathVariable double from,@PathVariable double to){
        return dishService.findDishByPrice(curPage,pageSize,from,to);
    }

    /**
     * 传入 当前页,页大小,商品最低价
     * */
    @RequestMapping(value = "/pages_lowest_price/{curPage}/{pageSize}/{from}",method = RequestMethod.GET)
    @ResponseBody
    public PageBean<Dish> findDishByLowestPrice(@PathVariable int curPage, @PathVariable int pageSize, @PathVariable double from){
        return dishService.findDishByLowestPrice(curPage,pageSize,from);
    }

    /**
     * 传入 当前页,页大小,商品最高价
     * */
    @RequestMapping(value = "/pages_highest_price/{curPage}/{pageSize}/{to}",method = RequestMethod.GET)
    @ResponseBody
    public PageBean<Dish> findDishByHighestPrice(@PathVariable int curPage, @PathVariable int pageSize,@PathVariable double to){
        return dishService.findDishByHighestPrice(curPage,pageSize,to);
    }

    // 修改菜品
    @PutMapping("/update")
    @ResponseBody
    public Response<Dish> updateDiscount(@RequestBody Dish dish) {
        return dishService.updateDish(dish);
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

