package com.backend.mapper;

import com.backend.entity.Rider;
import com.backend.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface RiderMapper {
    
    //根据id查找用户
    @Select("select * from rider where r_id = #{id}")
    Rider getById(@Param("id") int id);
    
    //TODO 修改骑手个人信息（哪个参数是主键?）
    @Update("update rider set contact=#{contact},u_pw=#{pwd}," +
            "real_name=#{real_name},school=#{school}, r_name=#{r_name} where r_id=#{stu_id}")
    int updateById(@Param("contact")String contact,
                   @Param("pwd")String password,
                   @Param("real_name")String realName,
                   @Param("school")String school,
                   @Param("r_id")String stuId,
                   @Param("r_name")String userName);
}
