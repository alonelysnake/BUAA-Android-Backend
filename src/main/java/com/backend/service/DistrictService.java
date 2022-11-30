package com.backend.service;

import com.backend.entity.District;
import com.backend.mapper.DistrictMapper;
import com.backend.utils.Response;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {
    @Autowired
    private DistrictMapper districtMapper;
    
    public Response<District> addDistrict(District district) {
        Response<District> res = new Response<>();
        int success = districtMapper.insert(district);
        res.setInfo(success,"添加成功","添加失败",district);
        return res;
    }

    public Response<District> updateDistrict(int id, String d_name) {
        Response<District> res = new Response<>();
        int success = districtMapper.updateName(id,d_name);
        res.setInfo(success,"修改成功","修改失败");
        return res;
    }

    public Response<District> deleteDistrict(int id) {
        Response<District> res = new Response<>();
        int success = districtMapper.deleteById(id);
        res.setInfo(success,"删除成功","删除失败");
        return res;
    }

    public List<District> getDistricts() {
        return districtMapper.listAll();
    }
}
