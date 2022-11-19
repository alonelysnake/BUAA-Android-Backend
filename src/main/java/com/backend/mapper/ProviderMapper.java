package com.backend.mapper;

import com.backend.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ProviderMapper {
    //TODO
    User getProviderById(/*TODO id*/);
    
    //TODO 重置密码
    int updatePassword(/*TODO id, password*/);
    
    //TODO
    int insertProvider(/*TODO provider*/);
    
    //TODO 注销
    int removeById(/*TODO id*/);
    
    //TODO
    List<User> listAll();
}
