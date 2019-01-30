package com.lover.entity;


import java.net.URLDecoder;
import java.util.Date;

/**
 * @Class: MType
 * @Author: ZLei
 * @Date: 14:05
 * @TODO: 回忆录类别实体
 */
public class MType {

    private int mid;    // 回忆录ID
    private String name;    // 回忆录名称
    private Date ctime; // 创建时间

    public MType(int mid, String name, Date ctime) {
        this.mid = mid;
        this.name = name;
        this.ctime = ctime;
    }

    public MType() {
    }


    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public void init(){
        this.ctime = new Date();
    }

    public void format(){
        try{
            this.name = URLDecoder.decode(this.name,"UTF-8");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "MType{" +
                "mid=" + mid +
                ", name='" + name + '\'' +
                ", ctime=" + ctime +
                '}';
    }
}
