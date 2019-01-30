package com.lover.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Class Bar
 * @Author ZLei
 * @Date 2019/1/18
 * @TODO 一级菜单类
 */
public class Bar {
    private String name;
    private String icon;
    private List<BarItem> child;

    public Bar() {
        child = new ArrayList<>();
    }

    public Bar(String name, String icon) {
        this.name = name;
        this.icon = icon;
        this.child = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<BarItem> getChild() {
        return child;
    }

    public void setChild(List<BarItem> child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "Bar{" +
                "name='" + name + '\'' +
                ", icon='" + icon + '\'' +
                ", child=" + child +
                '}';
    }

    public void addItem(BarItem item){
        child.add(item);
    }
}
