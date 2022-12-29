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

import java.util.ArrayList;
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
     * 商家id
     * */
    @RequestMapping(value = "/getDishByPid/{p_id}",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<Dish>> findDishByProvider(@PathVariable int p_id){
        return dishService.findDishByProvider(p_id);
    }

    /**
     * 商品名字
     * */
    @RequestMapping(value = "/getDishByName/{name}",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<Dish>> findDishByName(@PathVariable String name){
        return dishService.findDishByName(name);
    }

    /**
     * 传入 当前页,页大小,商品最低价，商品最高价
     * */
    @RequestMapping(value = "/getDishByPrice/{from}/{to}",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<Dish>> findDishByPrice(@PathVariable double from,@PathVariable double to){
        return dishService.findDishByPrice(from,to);
    }

    /**
     * 传入 当前页,页大小,商品最低价
     * */
    @RequestMapping(value = "/getDishByLowestPrice/{from}",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<Dish>> findDishByLowestPrice(@PathVariable double from){
        return dishService.findDishByLowestPrice(from);
    }

    /**
     * 传入 当前页,页大小,商品最高价
     * */
    @RequestMapping(value = "/getDishByHighestPrice/{to}",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<Dish>> findDishByHighestPrice(@PathVariable double to){
        return dishService.findDishByHighestPrice(to);
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

    @RequestMapping("/findDishByIds")
    @ResponseBody
    public Response<List<Dish>> findDishByIds(@RequestBody ArrayList<Integer> ids) {
        return dishService.findDishByIds(ids);
    }

    @RequestMapping("/getTotalCost")
    @ResponseBody
    public Response<Double> getTotalCost(@RequestBody ArrayList<Integer> ids) {
        return dishService.getTotalCost(ids);
    }
}

