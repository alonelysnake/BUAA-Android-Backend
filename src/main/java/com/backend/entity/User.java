package com.backend.entity;

public class User {
    public enum RiderState {
        NO,
        UNCERTAIN,
        YES
    }
    
    private int u_id;//账户id
    private String u_name;//用户名
    private String u_pw;//用户密码
    private RiderState is_rider = RiderState.NO;//是否为骑手
    private RiderState is_poor = RiderState.NO;//是否为贫困生
    private String photo;//用户头像url
    private String phone;//用户电话
    private String address;//送货地址
    private String contact;//个人简介
    private String accout_name;//骑手用户名?
    private String real_name;//骑手真实姓名
    private String stu_id;//骑手学生id
    private String school;//骑手所属学校
    
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
    
    public RiderState getIs_rider() {
        return is_rider;
    }
    
    public RiderState getIs_poor() {
        return is_poor;
    }
    
    public String getPhoto() {
        return photo;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public String getAccoutName() {
        return accout_name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public String getContact() {
        return contact;
    }
    
    public String getRealName() {
        return real_name;
    }
    
    public String getStuId() {
        return stu_id;
    }
    
    public String getSchool() {
        return school;
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
