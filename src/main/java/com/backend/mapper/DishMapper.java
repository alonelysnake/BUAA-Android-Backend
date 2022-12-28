package com.backend.mapper;

import com.backend.entity.Dish;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface DishMapper {
    // 新增菜品
    @Insert("insert into dish values(#{p_id},#{name},#{curPrice},#{price},#{sale},#{d_likes},#{d_dislikes},#{imgUrl},#{isHot},#{isTop},#{ingredient},#{isOver},#{pinyin})")
    @Options(useGeneratedKeys = true,keyProperty = "d_id",keyColumn = "d_id")
    int insert(Dish dish);

    @Update("update dish set name = #{name},curPrice = #{curPrice},price = #{price},imgUrl = #{imgUrl},isHot = #{isHot},isTop = #{isTop},ingredient = #{ingredient},isOver = #{isOver} where d_id = #{d_id}")
    int updateDish(Dish dish);

    // 删除菜品
    @Delete("delete from dish where d_id=#{d_id}")
    int removeById(@Param("d_id") int id);

    // 修改价格
    @Update("update dish set price = #{price} where d_id = #{d_id}")
    int updatePrice(@Param("d_id") int id, @Param("price") double price);

    // 点赞
    @Update("update dish set likes = likes + 1 where d_id = #{d_id}")
    int addLike(@Param("d_id") int id);

    // 点踩
    @Update("update dish set dislikes = dislikes + 1 where d_id = #{d_id}")
    int addDislike(@Param("d_id") int id);

    // 取消点赞
    @Update("update dish set likes = likes - 1 where d_id = #{d_id}")
    int cancelLike(@Param("d_id") int id);

    // 取消点踩
    @Update("update dish set dislikes = dislikes - 1 where d_id = #{d_id}")
    int cancelDislike(@Param("d_id") int id);

    // 根据商家ID查找菜品
    @Select("select * from dish where p_id = #{p_id}")
    List<Dish> findByPid(@Param("p_id") int pid);

    @Select("select count(*) from dish where p_id = #{p_id}")
    int countDishByPid(@Param("p_id") int pid);

    @Select("select * from dish where name like concat ('%',#{name},'%')")
    List<Dish> findByName(@Param("name") String name);

    @Select("select * from dish where pinyin like concat ('%',#{pinyin},'%')")
    List<Dish> findByPinyin(@Param("pinyin") String pinyin);

    @Select("select count(*) from dish where name like concat ('%',#{name},'%')")
    int countDishByName(@Param("name") String name);

    @Select("select * from dish where curPrice between #{from} and #{to}")
    List<Dish> findByPrice(@Param("from") double from,@Param("to") double to);

    @Select("select count(*) from dish where curPrice between #{from} and #{to}")
    int countDishByPrice(@Param("from") double from,@Param("to") double to);

    @Select("select count(*) from dish where curPrice > #{from}")
    int countDishByLowestPrice(@Param("from") double from);

    @Select("select * from dish where curPrice > #{from}")
    List<Dish> findByLowestPrice(@Param("from") double from);

    @Select("select count(*) from dish where curPrice < #{to}")
    int countDishByHighestPrice(@Param("to") double to);

    @Select("select * from dish where curPrice < #{to}")
    List<Dish> findByHighestPrice(@Param("to") double to);

    @Select("select count(*) from dish")
    int countDish();

    @Select("select * from dish")
    List<Dish> listAll();
    
    @Select("select d_id, name from dish where p_id = #{p_id}")
    List<HashMap<String,Object>>listDishById(@Param("p_id")String pid);
}

