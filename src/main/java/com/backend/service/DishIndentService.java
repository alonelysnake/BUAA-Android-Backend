package com.backend.service;

import com.backend.entity.Dish;
import com.backend.entity.DishIndent;
import com.backend.mapper.DishIndentMapper;
import com.backend.mapper.DishMapper;
import com.backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DishIndentService {
    @Autowired
    private DishIndentMapper mapper;

    public Response<DishIndent> insertDish(DishIndent dishIndent) {
        Response<DishIndent> res = new Response<>();
        int success = mapper.insert(dishIndent);
        res.setInfo(success,"插入成功","插入失败",dishIndent);
        return res;
    }

    public List<DishIndent> findByOid(int oid) {
        return mapper.findByOid(oid);
    }
    
    public List<Map<String,Object>> findNameCostByOid(int oid) {
        return mapper.findNameCostByOid(oid);
    }
}
