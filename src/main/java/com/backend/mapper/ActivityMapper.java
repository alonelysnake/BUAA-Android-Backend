package com.backend.mapper;

import com.backend.entity.Activity;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Mapper
@Repository
public interface ActivityMapper {
    @Select("select * from activity where act_id=#{act_id}")
    Activity getActivityById(@Param("act_id") int id);

    // 添加活动
    @Insert("insert into activity(start, end, a_id) values (#{start},#{end},#{a_id})")
    @Options(useGeneratedKeys = true,keyProperty = "a_id",keyColumn = "a_id")
    int insertActivity(Activity activity);

    // 取消活动
    @Delete("delete from activity where act_id = #{act_id}")
    int removeById(@Param("act_id") int id);

    // 修改活动结束时间
    @Update("update activity set end=#{end} where act_id=#{act_id}")
    int updateEndDate(@Param("act_id")int id, @Param("end") LocalDateTime end);
}
