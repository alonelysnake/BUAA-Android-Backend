package com.backend.entity;

public class Provider {
    private int id;
    private String name;
    private String password;
    private int scores;
    private int scorers;
    private int d_id;
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
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getPassword() {
        return password;
    }
}
