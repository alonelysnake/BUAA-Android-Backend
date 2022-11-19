package com.backend.entity;

public class Message {
    private int id;
    private int send;
    private int recv;
    private String name;
    private String password;
    private String content;
    
    public int getId() {
        return id;
    }
    
    public int getSend() {
        return send;
    }
    
    public int getRecv() {
        return recv;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getContent() {
        return content;
    }
}
