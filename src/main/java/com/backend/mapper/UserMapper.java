package com.backend.mapper;

import com.backend.entity.User;
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
public interface UserMapper {
    //新增用户
    @Insert("insert into user(u_name, u_pw) values(#{u_name},#{u_pw})")
    @Options(useGeneratedKeys = true,keyProperty = "u_id",keyColumn = "u_id")
    int insert(User user);
    
    //注销用户
    @Delete("delete from user where u_id = #{id}")
    int removeById(@Param("id") int id);
    
    //根据id查找用户
    @Select("select * from user where u_id = #{id}")
    User getUserById(@Param("id") int id);
    
    //根据名字（昵称）查找用户
    @Select("select * from user where u_name = #{name}")
    User getUserByName(@Param("name") String name);
    
    //获取所有
    @Select("select * from user")
    List<User> listAll();
    
    //重置密码为初始密码
    @Update("update user set u_pw = #{init_pwd} where u_id = #{uid}")
    int updatePasswordForReset(@Param("uid") int uid, @Param("init_pwd") String password);
    
    //修改密码
    @Update("update user set u_pw = #{new_pwd} where u_id = #{uid} and u_pw = #{old_pwd}")
    int updatePassword(@Param("uid") int uid, @Param("old_pwd") String oldPassword, @Param("new_pwd") String newPassword);
    
    //TODO 修改个人信息
    
    //统计用户（根据用户id+密码）
    @Select("select count(*) from user where u_id = #{uid} and u_pw = #{pwd}")
    int countByIdAndPwd(@Param("uid")int uid, @Param("pwd")String password);
    
    //统计用户（根据用户name+密码）
    @Select("select count(*) from user where u_name = #{name} and u_pw = #{pwd}")
    int countByNameAndPwd(@Param("name")String name, @Param("pwd")String password);
}
