package com.backend.mapper;

import com.backend.entity.Demo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DemoMapper {
    //sql查询函数
    @Select("select * from demo where demo.id=#{id} and demo.name=#{name}")
    Demo getDemo(@Param("id"/*和sql中{}的一致*/) int demoId, @Param("name") String name);
    
    @Select("select demo.id from demo where demo.id=#{d.id} and demo.name=#{d.name}")
    List<Integer> getDemo2(/*只有一个参数时可以忽略@Param注解*/Demo demo);
}
