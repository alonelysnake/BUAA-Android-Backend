package com.backend.mapper;

import com.backend.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface AdministratorMapper {
    //TODO
    User getAdminById(/*TODO id*/);
    
    //TODO 重置密码
    int updatePassword(/*TODO id, password*/);
    
    //TODO
    int insertAdmin(/*TODO Administrator*/);
    
    //TODO 注销
    int removeById(/*TODO id*/);
    
    //TODO
    List<User> listAll();
}
