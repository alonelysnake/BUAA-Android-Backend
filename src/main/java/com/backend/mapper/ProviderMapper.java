package com.backend.mapper;

import com.backend.entity.Provider;
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
public interface ProviderMapper {
    //新增用户
    @Insert("insert into provider(p_name, p_pw, scores, scorers, d_id)" +
            "values(#{name}, #{pwd}, 0, 0, #{d_id})")
    @Options(useGeneratedKeys = true, keyProperty = "p_id", keyColumn = "p_id")
    int insert(Provider provider);
    
    //注销用户
    @Delete("delete from provider where p_id = #{id}")
    int removeById(@Param("id") int id);
    
    //根据id查找用户
    @Select("select * from provider where p_id = #{id}")
    Provider getProviderById(@Param("id") int id);
    
    //根据名字（昵称）查找用户
    @Select("select * from provider where p_name = #{name}")
    Provider getProviderByName(@Param("name") String name);
    
    //获取所有商家
    @Select("select * from provider")
    List<Provider> listAll();
    
    //重置密码
    @Update("update provider set p_pw = #{init_pwd} where p_id = #{pid}")
    int updatePasswordForReset(@Param("pid") int pid, @Param("init_pwd") String password);
    
    //修改密码
    @Update("update provider set p_pw = #{new_pwd} where p_id = #{pid} and p_pw = #{old_pwd}")
    int updatePassword(@Param("pid") int pid, @Param("old_pwd") String oldPassword, @Param("new_pwd") String newPassword);
    
    //TODO 增加表函数，修改表属性为聚合?
    //修改评分（产生一个新的用户评价后）
    @Update("update provider set scores = scores + #{score}, scorers = scorers + 1" +
            "where p_id = #{id}")
    int updateByCreateNew(@Param("id") int id, @Param("score") int score);
    
    //修改评分（删除一个旧的用户评价后）
    @Update("update provider set scores = scores - #{score}, scorers = scorers - 1" +
            "where p_id = #{id}")
    int updateByRemoveOld(@Param("id") int id, @Param("score") int score);
    
    //统计用户（根据用户id+密码）
    @Select("select count(*) from provider where p_id = #{pid} and p_pw = #{pwd}")
    int countBy(@Param("pid")int pid,@Param("pwd")String password);
}
