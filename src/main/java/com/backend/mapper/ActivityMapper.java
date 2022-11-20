package com.backend.mapper;

import com.backend.entity.Activity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Mapper
@Repository
public interface ActivityMapper {
    @Select("select * from activity where act_id=#{act_id}")
    Activity getActivityById(@Param("act_id") int actId);

    @Insert("insert into activity(start, end, a_id) values (#{start},#{end},#{a_id})")
    void insertActivity(@Param("start")LocalDateTime start,@Param("end")LocalDateTime end,@Param("a_id")int adminId);

}
