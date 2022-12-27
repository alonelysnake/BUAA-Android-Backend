package com.backend.entity;

public class Rider {
    private int r_id;
    private String r_name;
    private String contact;
    private String r_pw;
    private String real_name;
    private String school;
    private boolean rider_state = false;
    
    public int getId() {
        return r_id;
    }
    
    public String getName() {
        return r_name;
    }
    
    public String getContact() {
        return contact;
    }
    
    public String getPassword() {
        return r_pw;
    }
    
    public String getRealName() {
        return real_name;
    }
    
    public String getSchool() {
        return school;
    }
    
    public boolean isRider_state() {
        return rider_state;
    }
}
