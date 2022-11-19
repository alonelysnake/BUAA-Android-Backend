package com.backend.entity;

public class FeedbackMessage {
    private int id;
    private int adminId;
    private int userId;
    private String content;
    
    public int getId() {
        return id;
    }
    
    public int getAdminId() {
        return adminId;
    }
    
    public int getUserId() {
        return userId;
    }
    
    public String getContent() {
        return content;
    }
}
