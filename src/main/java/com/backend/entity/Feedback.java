package com.backend.entity;

public class Feedback {
    private int fb_id;
    private int a_id;
    private int u_id;
    private String fb_content;
    
    public int getId() {
        return fb_id;
    }
    
    public int getAdminId() {
        return a_id;
    }
    
    public int getUserId() {
        return u_id;
    }
    
    public String getContent() {
        return fb_content;
    }
}
