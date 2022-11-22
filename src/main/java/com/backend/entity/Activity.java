package com.backend.entity;

import java.time.LocalDateTime;

public class Activity {
    private int act_id;
    private LocalDateTime start;
    private LocalDateTime end;
    private int a_id;
    //TODO 活动信息


    public Activity(LocalDateTime start, LocalDateTime end, int a_id) {
        this.start = start;
        this.end = end;
        this.a_id = a_id;
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
