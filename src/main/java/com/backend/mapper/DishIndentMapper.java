package com.backend.mapper;

import com.backend.entity.DishIndent;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DishIndentMapper {
    //新增订单-菜品信息
    @Insert("insert into dishIndent value(#{o_id},#{d_id})")
    int insert(DishIndent dishIndent);

    //查询订单对应菜品id
    @Select("select * from dishIndent where o_id=#{o_id}")
    List<DishIndent> findByOid(@Param("o_id")int oid);
}
