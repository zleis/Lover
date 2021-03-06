package com.lover.entity;

import java.net.URLDecoder;
import java.util.Date;

/**
 * @Class: PType
 * @Author: ZLei
 * @Date: 14:05
 * @TODO: 照片类别实体
 */
public class PType {

    private int pid;
    private String name;
    private Date ctime;

    public PType(int pid, String name, Date ctime) {
        this.pid = pid;
        this.name = name;
        this.ctime = ctime;
    }
    public PType() {
    }
    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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
        return "PType{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", ctime=" + ctime +
                '}';
    }
}
