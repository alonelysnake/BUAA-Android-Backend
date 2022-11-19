package com.backend.entity;

import java.time.LocalDateTime;

public class Message {
    private int id;
    private int send;
    private int recv;
    private LocalDateTime time;
    private String content;

    public LocalDateTime getTime() {
        return time;
    }

    public int getId() {
        return id;
    }
    
    public int getSend() {
        return send;
    }
    
    public int getRecv() {
        return recv;
    }

    public String getContent() {
        return content;
    }
}
