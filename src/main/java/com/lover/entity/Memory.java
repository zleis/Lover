package com.lover.entity;

import java.util.Date;

/**
 * @Class Memory
 * @TODO 回忆录实体对象
 */
public class Memory {

    private String mid; // 回忆录ID
    private Manager manager; // 创建人
    private Date ctime; // 创建时间
    private int rtime;  // 阅读次数
    private int type;   // 类别
    private String title;   // 题目
    private String intro;   // 简介
    private String content; // 内容

    public Memory() {
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "Memory{" +
                "mid='" + mid + '\'' +
                ", manager=" + manager.toString() +
                ", ctime=" + ctime +
                ", rtime=" + rtime +
                ", type=" + type +
                ", title='" + title + '\'' +
                ", intro='" + intro + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
