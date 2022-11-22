package com.backend.mapper;

import com.backend.entity.Comment;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {
    // 发表评论
    @Insert("insert into comment value(#{c_content},#{u_time},#{recommend},#{u_id},#{d_id})")
    @Options(useGeneratedKeys = true,keyProperty = "c_id",keyColumn = "c_id")
    int insert(Comment comment);

    // 删除评论
    @Delete("delete from comment where c_id=#{c_id}")
    int removeById(@Param("c_id")int id);

    // 根据评论用户查找评论
    @Select("select * from comment where u_id=#{u_id}")
    List<Comment> getCommentsByUid(@Param("u_id")int u_id);

    // 根据菜品查找评论
    @Select("select * from comment where d_id=#{d_id}")
    List<Comment> getCommentsByDid(@Param("d_id")int d_id);

    @Select("select * from comment")
    List<Comment> listAll();

    @Select("select count(*) from comment")
    Integer countComment();
}
