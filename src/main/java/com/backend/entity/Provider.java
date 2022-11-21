package com.backend.entity;

public class Provider {
    private int p_id;
    private String p_name;
    private String p_pw;
    private int scores;//总分
    private int scorers;//评分人数
    private int d_id;//区域
    //TODO 详细信息

    public int getScores() {
        return scores;
    }

    public int getScorers() {
        return scorers;
    }

    public int getD_id() {
        return d_id;
    }

    public int getId() {
        return p_id;
    }
    
    public String getName() {
        return p_name;
    }
    
    public String getPassword() {
        return p_pw;
    }
}
