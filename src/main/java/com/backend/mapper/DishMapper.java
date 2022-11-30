package com.backend.mapper;

import com.backend.entity.Dish;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DishMapper {
    // 新增菜品
    @Insert("insert into dish values(#{p_id},#{discount},#{price},#{sale},#{d_likes},#{d_dislikes})")
    @Options(useGeneratedKeys = true,keyProperty = "d_id",keyColumn = "d_id")
    int insert(Dish dish);

    // 删除菜品
    @Delete("delete from dish where d_id=#{d_id}")
    int removeById(@Param("d_id") int id);

    // 修改折扣
    @Update("update dish set discount = #{discount} where d_id = #{d_id}")
    int updateDiscount(@Param("d_id") int id, @Param("discount") double discount);

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

    @Select("select count(*) from dish")
    int countDish();

    @Select("select * from dish")
    List<Dish> listAll();
}

