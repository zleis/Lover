package com.lover.entity;

public class Menu {

    private int mid;
    private String name;
    private String link;

    public Menu(int mid, String name, String link) {
        this.mid = mid;
        this.name = name;
        this.link = link;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "mid=" + mid +
                ", name='" + name + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
