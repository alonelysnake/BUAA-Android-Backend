package com.backend.entity;

public class Provider {
    private String p_id;
    private String p_name;
    private String p_pw;
    private int scores;//总分
    private int scorers;//评分人数
    private int d_id;//区域
    private String photo;//商家照片url
    private String phone;//商家联系电话
    //TODO 详细信息
    
    
    public Provider() {
    }
    
    public Provider(String id, String p_name, String p_pw, int d_id) {
        this.p_id = id;
        this.p_name = p_name;
        this.p_pw = p_pw;
        this.d_id = d_id;
    }

    public Provider(String p_id, String p_name, String p_pw, int scores, int scorers, int d_id, String photo, String phone) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.p_pw = p_pw;
        this.scores = scores;
        this.scorers = scorers;
        this.d_id = d_id;
        this.photo = photo;
        this.phone = phone;
    }

    public String getP_id() {
        return p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public String getP_pw() {
        return p_pw;
    }

    public String getPhoto() {
        return photo;
    }

    public String getPhone() {
        return phone;
    }

    public int getScores() {
        return scores;
    }

    public int getScorers() {
        return scorers;
    }

    public int getD_id() {
        return d_id;
    }

    public String getId() {
        return p_id;
    }
    
    public String getName() {
        return p_name;
    }
    
    public String getPassword() {
        return p_pw;
    }
}
