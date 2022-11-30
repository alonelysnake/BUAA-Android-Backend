package com.backend.mapper;

import com.backend.entity.Favor;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FavorMapper {

    @Insert("insert into favor value(#{u_id},#{d_id})")
    int insert(Favor favor);

    @Select("select * from favor where u_id=#{u_id}")
    List<Favor> findByUid(@Param("u_id")int uid);

    @Delete("delete from favor where u_id=#{u_id} and d_id=#{d_id}")
    int removeFavor(Favor favor);

    @Select("select count(*) from favor where u_id=#{u_id}")
    int countFavorByUid(@Param("u_id")int uid);
}
