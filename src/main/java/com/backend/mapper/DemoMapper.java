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
    //方法命名规范
    //获取单个对象：get*，如getById
    //获取多个对象：list*，如listById，listAll
    //插入对象：insert*
    //删除对象：remove*，如removeById
    //修改对象：update*，如updateById
    //求和统计：count*
    
    //sql查询函数
    @Select("select * from demo where demo.id=#{id} and demo.name=#{name}")
    Demo getDemo(@Param("id"/*和sql中{}的一致*/) int demoId, @Param("name") String name);
    
    @Select("select demo.id from demo where demo.id=#{d.id} and demo.name=#{d.name}")
    List<Integer> getDemo2(/*只有一个参数时可以忽略@Param注解*/Demo demo);
}
