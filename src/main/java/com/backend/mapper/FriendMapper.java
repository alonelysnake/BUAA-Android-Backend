package com.backend.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FriendMapper {
    //增加新的好友关系
    @Insert("insert into friend(u_id, f_id) values (#{uid}, #{fid})")
    int insert(@Param("uid") String user, @Param("fid") String friend);
    
    //删除好友关系
    @Delete("delete from friend where u_id = #{uid} and f_id = #{fid}")
    int remove(@Param("uid") String user, @Param("fid") String friend);
    
    //得到某用户的所有好友id
    @Select("select f_id from friend where u_id = #{uid}")
    List<Integer> listFriendId(@Param("uid") String user);
}
