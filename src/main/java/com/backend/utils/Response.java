package com.backend.utils;

public class Response<T> {
    private boolean state;//状态
    private String msg;//内容
    private T data;//实际所需数据
    
    public Response() {
    }
    
    public Response(boolean state, String msg, T data) {
        this.state = state;
        this.msg = msg;
        this.data = data;
    }
    
    public void setState(boolean state) {
        this.state = state;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    public boolean getState() {
        return state;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public T getData() {
        return data;
    }
}
