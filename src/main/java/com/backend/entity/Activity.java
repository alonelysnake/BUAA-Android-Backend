package com.backend.entity;

import java.time.LocalDateTime;

public class Activity {
    private int act_id;
    private LocalDateTime start;
    private LocalDateTime end;
    private int a_id;
    private String imgUrl;
    private String description;

    public Activity(LocalDateTime start, int a_id, String imgUrl, String description) {
        this.start = start;
        this.a_id = a_id;
        this.imgUrl = imgUrl;
        this.description = description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public int getAct_id() {
        return act_id;
    }
    
    public LocalDateTime getStart() {
        return start;
    }
    
    public LocalDateTime getEnd() {
        return end;
    }
    
    public int getA_id() {
        return a_id;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + act_id +
                ", start=" + start +
                ", end=" + end +
                ", administrator=" + a_id +
                '}';
    }
}
