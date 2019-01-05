package com.lover.entity;

import java.util.Date;

/**
 * @Class: Answer
 * @Author: ZLei
 * @Date: 14:10
 * @TODO: 简答实体
 */
public class Answer {

    private String aid;         // 简答ID
    private Manager manager;    // 简答人
    private Date ctime;         // 创建时间
    private int rtime;          // 阅读次数
    private String ques;        // 问题
    private String intr;        // 简介
    private String content;     // 答案

    public Answer() {
    }

    public Answer(String aid, Date ctime, int rtime, String intr, String ques, String content) {
        this.aid = aid;
        this.ctime = ctime;
        this.rtime = rtime;
        this.ques = ques;
        this.intr = intr;
        this.content = content;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getQues() {
        return ques;
    }

    public void setQues(String ques) {
        this.ques = ques;
    }

    public String getIntr() {
        return intr;
    }

    public void setIntr(String intr) {
        this.intr = intr;
    }

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "aid='" + aid + '\'' +
                ", manager=" + manager.toString() +
                ", ctime=" + ctime +
                ", rtime=" + rtime +
                ", ques='" + ques + '\'' +
                ", intr='" + intr + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
