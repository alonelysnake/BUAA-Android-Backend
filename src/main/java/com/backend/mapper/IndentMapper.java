package com.backend.mapper;

import com.backend.entity.Indent;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
@Repository
public interface IndentMapper {
    // 新增订单
    @Insert("insert into indent(o_time, cost, state, address, u_id, rider, p_id) " +
            "values (#{o_time}, #{cost}, #{state}, #{address}, #{u_id}, #{rider}, #{p_id})")
    @Options(useGeneratedKeys = true,keyProperty = "o_id",keyColumn = "o_id")
    int insert(Indent indent);
    
    //按照订单id删除订单
    @Delete("delete from indent where o_id = #{id}")
    int removeById(@Param("id") int id);
    
    //按用户查询所有订单
    @Select("select * from indent where u_id = #{uid}")
    List<Indent> listByUser(@Param("uid") int uid);
    
    //按骑手查询所有订单
    @Select("select * from indent where rider = #{rid}")
    List<Indent> listByRider(@Param("rid") int rider);
    
    //按商家查询所有订单
    @Select("select * from indent where p_id = #{pid}")
    List<Indent> listByProvider(@Param("pid") int provider);
    
    //修改订单状态
    @Update("update indent set state = #{state} where o_id = #{id}")
    int updateState(@Param("state") Indent.OrderState newState, @Param("id") int id);
}
