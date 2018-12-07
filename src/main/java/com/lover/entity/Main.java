package com.lover.entity;

public class Main {
    private int id;

    private String conent;
    private String className;

    public Main(int id, String conent, String className) {
        this.id = id;
        this.conent = conent;
        this.className = className;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConent() {
        return conent;
    }

    public void setConent(String conent) {
        this.conent = conent;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public String toString() {
        return "Main{" +
                "id=" + id +
                ", conent='" + conent + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
