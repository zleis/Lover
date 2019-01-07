package com.lover.entity;

public enum URLEnum {
    URL_LOGIN("/api/manager/login","管理员登录"),

    ;


    private String url;
    private String comment;
    private static String baseURL = "http://localhost:8080/lover";

    public String getUrl() {
        return baseURL + url;
    }

    public String getComment() {
        return comment;
    }

    URLEnum(String url, String comment) {
        this.url = url;
        this.comment = comment;
    }
}
