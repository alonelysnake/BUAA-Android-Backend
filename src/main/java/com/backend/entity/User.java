package com.backend.entity;

public class User {
    private int u_id;
    private String u_name;
    private String u_pw;
    //TODO 其他用户信息
    
    
    public User(String u_name, String u_pw) {
        this.u_name = u_name;
        this.u_pw = u_pw;
    }
    
    public int getId() {
        return u_id;
    }
    
    public String getName() {
        return u_name;
    }
    
    public String getPassword() {
        return u_pw;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "u_id=" + u_id +
                ", u_name='" + u_name + '\'' +
                ", u_pw='" + u_pw + '\'' +
                '}';
    }
}
