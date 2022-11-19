package com.backend.entity;

import java.time.LocalDateTime;

public class Activity {
    private int id;
    private LocalDateTime start;
    private LocalDateTime end;
    private int administrator;
    //TODO 活动信息
    
    public int getId() {
        return id;
    }
    
    public LocalDateTime getStart() {
        return start;
    }
    
    public LocalDateTime getEnd() {
        return end;
    }
    
    public int getAdministrator() {
        return administrator;
    }
}
