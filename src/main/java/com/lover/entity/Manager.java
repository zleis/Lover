package com.lover.entity;

/**
 *
 * @class: Manager
 * @date: 2018/11/19
 * @author: zlei
 * @todo 管理员
 */
public class Manager {

    private String mid;
    private String pass;

    public Manager(String mid, String pass) {
        this.mid = mid;
        this.pass = pass;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mid='" + mid + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
