package com.lover.entity;

import java.util.Date;

public class Memory {

    private String mid; // 回忆录ID
    private String man; // 创建人
    private String manID;   // 创建人ID
    private Date ctime; // 创建时间
    private int rtime;  // 阅读次数
    private int type;   // 类别
    private String title;   // 题目
    private String intro;   // 简介
    private String content; // 内容

    public Memory() {
    }

    public Memory(String mid, String man, Date ctime, int rtime, int type, String title,String intro, String content) {
        this.mid = mid;
        this.man = man;
        this.ctime = ctime;
        this.rtime = rtime;
        this.type = type;
        this.title = title;
        this.intro = intro;
        this.content = content;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMan() {
        return man;
    }

    public void setMan(String man) {
        this.man = man;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public int getRtime() {
        return rtime;
    }

    public void setRtime(int rtime) {
        this.rtime = rtime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getManID() {
        return manID;
    }

    public void setManID(String manID) {
        this.manID = manID;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "mid='" + mid + '\'' +
                ", man='" + man + '\'' +
                ", ctime=" + ctime +
                ", rtime=" + rtime +
                ", type=" + type +
                ", content='" + content + '\'' +
                '}';
    }
}
