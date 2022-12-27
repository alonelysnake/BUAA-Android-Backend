package com.backend.mapper;

import com.backend.entity.Feedback;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FeedbackMapper {
    //增加反馈
    //TODO 新增时是否有管理员id?
    @Insert("insert into feedback(a_id, u_id, fb_content) values (#{a_id}, #{u_id}, #{fb_content})")
    @Options(useGeneratedKeys = true,keyProperty = "fb_id",keyColumn = "fb_id")
    int insert(Feedback feedback);
    
    //根据反馈id进行删除
    @Delete("delete from feedback where fb_id = #{id}")
    int removeById(@Param("id") int id);
    
    @Select("select * from feedback")
    List<Feedback> listAll();
    
    //按用户id查某用户的所有反馈
    @Select("select * from feedback where u_id = #{uid}")
    List<Feedback> listByUserId(@Param("uid") int uid);
    
    //按管理员id查管理员（处理？）的所有反馈
    @Select("select * from feedback where a_id = #{a_id}")
    List<Feedback> listByAdminId(@Param("a_id") int admin);
    
    //管理员处理后增加处理的管理员id名?
    @Update("update feedback set a_id = #{admin} where fb_id = #{id}")
    int updateAdminId(@Param("id") int id, @Param("admin") int admin);
}
