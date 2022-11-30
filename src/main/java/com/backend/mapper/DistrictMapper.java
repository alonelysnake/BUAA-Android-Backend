package com.backend.mapper;

import com.backend.entity.District;
import com.backend.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DistrictMapper {
    // 新增食堂
    @Insert("insert into district values(#{d_id},#{d_name})")
    @Options(useGeneratedKeys = true,keyProperty = "d_id",keyColumn = "d_id")
    int insert(District district);

    // 修改食堂名字
    @Update("update district set d_name=#{d_name} where d_id=#{d_id}")
    int updateName(@Param("d_id") int id,@Param("d_name") String d_name);

    // 删除食堂
    @Delete("delete from district where d_id=#{d_id}")
    int deleteById(@Param("d_id") int id);

    // 查询
    @Select("select * from district")
    List<District> listAll();
}
