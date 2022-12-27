package com.backend.service;

import com.backend.utils.Response;
import com.backend.entity.Indent;
import com.backend.mapper.IndentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndentService {
    @Autowired
    private IndentMapper indentMapper;
    
    //添加订单
    public Response<String> addIndent(Indent indent) {
        Response<String> res = new Response<>();
        try {
            int success = indentMapper.insert(indent);
            if (success == 0) {
                res.setState(false);
                res.setMsg("提交订单失败");
            } else {
                res.setState(true);
                res.setData("提交订单成功");
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
    //改变订单状态
    public Response<Boolean> changeState(int id, Indent.OrderState newState) {
        Response<Boolean> res = new Response<>();
        try {
            int success = indentMapper.updateState(id, newState);
            if (success == 0) {
                res.setState(false);
                res.setMsg("变更订单状态失败");
            } else {
                res.setState(true);
                res.setData(true);
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
    //获取用户所有订单
    public Response<List<Indent>> getUserIndents(String uid) {
        Response<List<Indent>> res = new Response<>();
        try {
            List<Indent> indents = indentMapper.listByUser(uid);
            if (indents == null) {
                res.setState(false);
                res.setMsg("获取用户所有订单失败");
            } else {
                res.setState(true);
                res.setData(indents);
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
    //按照订单状态获取所有订单
    public Response<List<Indent>> getUserIndents(String uid, Indent.OrderState state) {
        Response<List<Indent>> res = new Response<>();
        try {
            List<Indent> indents = indentMapper.listByUserAndState(uid, state);
            if (indents == null) {
                res.setState(false);
                res.setMsg("获取用户状态为" + state + "的订单失败");
            } else {
                res.setState(true);
                res.setData(indents);
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
    //获取商家所有订单
    public Response<List<Indent>> getProviderIndents(String pid) {
        Response<List<Indent>> res = new Response<>();
        try {
            List<Indent> indents = indentMapper.listByProvider(pid);
            if (indents == null) {
                res.setState(false);
                res.setMsg("获取商家所有订单失败");
            } else {
                res.setState(true);
                res.setData(indents);
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
    //按照商家和订单状态获取所有订单
    public Response<List<Indent>> getProviderIndents(String pid, Indent.OrderState state) {
        Response<List<Indent>> res = new Response<>();
        try {
            List<Indent> indents = indentMapper.listByProviderAndState(pid, state);
            if (indents == null) {
                res.setState(false);
                res.setMsg("获取商家状态为" + state + "的订单失败");
            } else {
                res.setState(true);
                res.setData(indents);
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
    //获取骑手所有订单
    public Response<List<Indent>> getRiderIndents(String rid) {
        Response<List<Indent>> res = new Response<>();
        try {
            List<Indent> indents = indentMapper.listByRider(rid);
            if (indents == null) {
                res.setState(false);
                res.setMsg("获取骑手所有订单失败");
            } else {
                res.setState(true);
                res.setData(indents);
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
    //按照订单状态获取骑手所有订单
    public Response<List<Indent>> getRiderIndents(String rid, Indent.OrderState state) {
        Response<List<Indent>> res = new Response<>();
        try {
            List<Indent> indents = indentMapper.listByRiderAndState(rid, state);
            if (indents == null) {
                res.setState(false);
                res.setMsg("获取骑手状态为" + state + "的订单失败");
            } else {
                res.setState(true);
                res.setData(indents);
            }
        } catch (Exception e) {
            res.setState(false);
            res.setMsg(e.getMessage());
            e.printStackTrace();
        }
        return res;
    }
    
    public Response<Indent> getIndentInfo(int oid) {
        Response<Indent> res = new Response<>();
        try {
            res.setData(indentMapper.getIdentById(oid));
            res.setState(true);
        } catch (Exception e) {
            res.setState(false);
            e.printStackTrace();
        }
        return res;
    }
}
