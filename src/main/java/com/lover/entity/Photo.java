package com.lover.entity;

import java.net.URLDecoder;
import java.util.Date;

public class Photo {
    private String pid;    // 照片ID
    private String title;   // 照片名称
    private String intro;   // 照片简介
    private String des;     // 照片描述
    private String place;   // 照片拍摄地点
    private Date ctime;     // 照片上传时间
    private int type;       // 照片类别
    private String src;     // 路径
    private PType pType;    // 类别

    public Photo() {
    }

    public Photo(String pid, String title, String intro, String des, String place, Date ctime, int type, String src) {
        this.pid = pid;
        this.title = title;
        this.intro = intro;
        this.des = des;
        this.place = place;
        this.ctime = ctime;
        this.type = type;
        this.src = src;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getSrc() {
        return src;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void init(){
        this.ctime = new Date();
    }

    public void format(){
        try{
            this.title = URLDecoder.decode(this.title,"UTF-8");
            this.intro = URLDecoder.decode(this.intro, "UTF-8");
            this.des = URLDecoder.decode(this.des,"UTF-8");
            this.place = URLDecoder.decode(this.place, "UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Photo{" +
                "pid=" + pid +
                ", title='" + title + '\'' +
                ", intro='" + intro + '\'' +
                ", des='" + des + '\'' +
                ", place='" + place + '\'' +
                ", ctime=" + ctime +
                ", type=" + type +
                '}';
    }
}
