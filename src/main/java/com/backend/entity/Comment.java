package com.backend.entity;

import java.time.LocalDateTime;

public class Comment {
    private int id;
    private String content;
    private LocalDateTime time;
    
    public int getId() {
        return id;
    }
    
    public String getContent() {
        return content;
    }
    
    public LocalDateTime getTime() {
        return time;
    }
}
