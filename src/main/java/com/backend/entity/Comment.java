package com.backend.entity;

import java.time.LocalDateTime;

public class Comment {
    private int c_id;
    private String c_content;
    private LocalDateTime c_time;
    private boolean recommend;
    private int u_id;
    private int d_id;

    public boolean isRecommend() {
        return recommend;
    }

    public int getU_id() {
        return u_id;
    }

    public int getD_id() {
        return d_id;
    }

    public int getId() {
        return c_id;
    }
    
    public String getContent() {
        return c_content;
    }
    
    public LocalDateTime getTime() {
        return c_time;
    }
}
