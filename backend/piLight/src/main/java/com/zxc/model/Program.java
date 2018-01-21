package com.zxc.model;

import java.util.Date;

public class Program {
    private Integer id;

    private String name;

    private String playTime;

    private String eNum;

    private String hanfanUrl;

    private String playUrl;

    private String baiduUrl;

    private String baiduPwd;

    private Date crtTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPlayTime() {
        return playTime;
    }

    public void setPlayTime(String playTime) {
        this.playTime = playTime == null ? null : playTime.trim();
    }

    public String geteNum() {
        return eNum;
    }

    public void seteNum(String eNum) {
        this.eNum = eNum == null ? null : eNum.trim();
    }

    public String getHanfanUrl() {
        return hanfanUrl;
    }

    public void setHanfanUrl(String hanfanUrl) {
        this.hanfanUrl = hanfanUrl == null ? null : hanfanUrl.trim();
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl == null ? null : playUrl.trim();
    }

    public String getBaiduUrl() {
        return baiduUrl;
    }

    public void setBaiduUrl(String baiduUrl) {
        this.baiduUrl = baiduUrl == null ? null : baiduUrl.trim();
    }

    public String getBaiduPwd() {
        return baiduPwd;
    }

    public void setBaiduPwd(String baiduPwd) {
        this.baiduPwd = baiduPwd == null ? null : baiduPwd.trim();
    }

    public Date getCrtTime() {
        return crtTime;
    }

    public void setCrtTime(Date crtTime) {
        this.crtTime = crtTime;
    }
}