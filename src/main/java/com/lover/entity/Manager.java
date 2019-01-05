package com.lover.entity;

/**
 *
 * @class: Manager
 * @date: 2018/11/19
 * @author: zlei
 * @todo 管理员实体
 */
public class Manager {

    private String mid;
    private String pass;
    private String name;
    private String photo;

    public Manager() {
    }

    public Manager(String mid, String pass, String name, String photo) {
        this.mid = mid;
        this.pass = pass;
        this.name = name;
        this.photo = photo;
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


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "mid='" + mid + '\'' +
                ", pass='" + pass + '\'' +
                ", name='" + name + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
