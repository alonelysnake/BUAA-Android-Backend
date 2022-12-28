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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface IndentMapper {
    // 新增订单
    @Insert("insert into indent(o_time, cost, state, address, u_id, rider, p_id) " +
            "values (#{o_time}, #{cost}, #{state}, #{address}, #{u_id}, #{rider}, #{p_id})")
    @Options(useGeneratedKeys = true, keyProperty = "o_id", keyColumn = "o_id")
    int insert(Indent indent);
    
    //按照订单id删除订单
    @Delete("delete from indent where o_id = #{id}")
    int removeById(@Param("id") String id);
    
    @Select("select addr, cost, o_comment, p_name from indent, provider where o_id = #{oid} and indent.p_id = provider.p_id")
    Map<String, Object> getIdentById(@Param("oid") int oid);
    
    //按用户查询所有订单
    @Select("select * from indent where u_id = #{uid}")
    List<Indent> listByUser(@Param("uid") String uid);
    
    //按用户和订单状态查询所有订单
    @Select("select * from indent where u_id = #{uid} and state = #{state}")
    List<Indent> listByUserAndState(@Param("uid") String uid, @Param("state") Indent.OrderState state);
    
    //按骑手查询所有订单
    @Select("select * from indent where rider = #{rid}")
    List<Indent> listByRider(@Param("rid") String rider);
    
    //按骑手和订单状态查询所有订单
    @Select("select * from indent where r_id = #{rid} and state = #{state}")
    List<Indent> listByRiderAndState(@Param("rid") String rid, @Param("state") Indent.OrderState state);
    
    //按商家查询所有订单
    @Select("select * from indent where p_id = #{pid}")
    List<Indent> listByProvider(@Param("pid") String provider);
    
    //按商家和订单状态查询所有订单
    @Select("select * from indent where p_id = #{pid} and state = #{state}")
    List<Indent> listByProviderAndState(@Param("pid") String pid, @Param("state") Indent.OrderState state);
    
    //修改订单状态
    @Update("update indent set state = #{state} where o_id = #{id}")
    int updateState(@Param("id") int id, @Param("state") Indent.OrderState newState);
    
    @Select("select sum(sum) from dish, dishIndent, indent " +
            "where dish.d_id = dishIndent.d_id and indent.o_id = dishIndent.o_id and " +
            "dish.d_id=#{d_id} and o_time between #{time1} and #{time2}")
    Integer getDishNumByDate(@Param("d_id")int d_id, @Param("time1")LocalDateTime time1,@Param("time2")LocalDateTime time2);
}
