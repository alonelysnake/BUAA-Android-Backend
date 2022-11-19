package com.backend.entity;

import java.time.LocalDateTime;

public class Comment {
    private int id;
    private String content;
    private LocalDateTime time;
    private boolean isRecommend;
    private int u_id;
    private int d_id;

    public boolean isRecommend() {
        return isRecommend;
    }

    public int getU_id() {
        return u_id;
    }

    public int getD_id() {
        return d_id;
    }

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
