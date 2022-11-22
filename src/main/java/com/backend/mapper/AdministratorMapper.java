package com.backend.mapper;

import com.backend.entity.Administrator;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdministratorMapper {

    @Select("select * from admin where a_id=#{a_id}")
    Administrator getAdminById(@Param("a_id")int id);
    
    @Update("update admin set a_pw=#{a_pw} where a_id=#{a_id}")
    int updatePassword(@Param("a_id")int id,@Param("a_pw")String password);

    @Insert("insert into admin values(#{a_id},#{a_name},${a_pw})")
    @Options(useGeneratedKeys = true,keyProperty = "a_id",keyColumn = "a_id")
    int insertAdmin(Administrator administrator);
    
    @Delete("delete from admin where a_id=#{a_id}")
    int removeById(@Param("a_id")int id);
    
    @Select("select * from admin")
    List<Administrator> listAll();

    @Select("select count(*) from admin where a_name = #{name} and a_pw = #{pwd}")
    int countByNameAndPwd(@Param("name")String name, @Param("pwd")String password);

    @Select("select * from admin where a_name = #{name}")
    Administrator getAdminByName(@Param("name") String name);

    @Update("update admin set a_pw = #{init_pwd} where a_id = #{a_id}")
    int updatePasswordForReset(@Param("a_id") int id, @Param("init_pwd") String password);

    @Select("select a.id from admin a where a.a_id=#{a_id} and a_pw=#{a_pw}")
    Integer login(Administrator admin);
}
