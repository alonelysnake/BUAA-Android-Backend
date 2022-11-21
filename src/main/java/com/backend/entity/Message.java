package com.backend.entity;

import java.time.LocalDateTime;

public class Message {
    private int m_id;
    private int s_id;
    private int r_id;
    private LocalDateTime m_time;
    private String m_content;

    public LocalDateTime getTime() {
        return m_time;
    }

    public int getId() {
        return m_id;
    }
    
    public int getSend() {
        return s_id;
    }
    
    public int getRecv() {
        return r_id;
    }

    public String getContent() {
        return m_content;
    }
}
