package com.backend.controller;

import com.backend.entity.Dish;
import com.backend.entity.District;
import com.backend.service.DistrictService;
import com.backend.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("district")
public class DistrictController {
    @Autowired
    private DistrictService service;

    // 添加食堂
    @PostMapping("/insert")
    @ResponseBody
    public Response<District> insertDistrict(@RequestBody District district) {
        return service.addDistrict(district);
    }

    // 删除食堂
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Response<District> deleteDistrict(@PathVariable int id) {
        return service.deleteDistrict(id);
    }

    // 修改食堂名
    @PutMapping("/update/discount/{id}/{name}")
    @ResponseBody
    public Response<District> updateName(@PathVariable int id,@PathVariable String name) {
        return service.updateDistrict(id,name);
    }

    @RequestMapping(value = "/select",method = RequestMethod.GET)
    @ResponseBody
    public Response<List<District>> findDistrict() {
        return service.getDistricts();
    }

    @RequestMapping(value = "/getName/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Response<String> findName(@PathVariable int id) {
        return service.getName(id);
    }
}
