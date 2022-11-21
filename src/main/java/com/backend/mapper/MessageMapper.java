package com.backend.mapper;

import com.backend.entity.Message;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
@Repository
public interface MessageMapper {
    //增加消息
    @Insert("insert into message(s_id, r_id, m_time, m_content)" +
            "values(#{s_id}, #{r_id}, #{m_time}, #{m_content})")
    @Options(useGeneratedKeys = true,keyProperty = "m_id",keyColumn = "m_id")
    int insert(Message message);
    
    //删除单条消息
    @Delete("delete from message where m_id = #{id}")
    int removeById(@Param("id") int id);
    
    //按照发送者和接收者删除二人的所有消息
    @Delete("delete from message where s_id = #{sid} and r_id = #{rid}")
    int removeBySendRecv(@Param("sid") int send, @Param("rid") int recv);
    
    //查看二者之间的所有消息
    @Select("select * from message where s_id = #{sid} and r_id = #{rid}")
    List<Message> listBySendRecv(@Param("sid") int send, @Param("rid") int recv);
}
