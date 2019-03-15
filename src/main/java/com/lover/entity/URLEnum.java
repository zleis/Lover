package com.lover.entity;

public enum URLEnum {
    URL_LOGIN("/api/manager/login","管理员登录"),
    URL_LOGOUT("/api/manager/logout","管理员登出"),
    URL_INFO_EDIT("/api/manager/infoEdit", "修改密码"),
    URL_ANSWER_ADD("/api/manager/answerAdd","添加简答"),
    URL_ANSWER_DEL("/api/manager/answerDel","删除简答"),
    URL_ANSWER_EDIT("/api/manager/answerEdit","修改简答"),
    URL_MEMORY_ADD("/api/manager/memoryAdd", "添加回忆录"),
    URL_MEMORY_DEL("/api/manager/memoryDel", "删除回忆录"),
    URL_MEMORY_EDIT("/api/manager/memoryEdit", "修改回忆录"),
    URL_MESSAGE_ADD("/api/manager/messageAdd", "添加语录"),
    URL_MESSAGE_DEL("/api/manager/messageDel", "删除语录"),
    URL_MTYPE_ADD("/api/manager/mtypeAdd", "添加回忆录类别"),
    URL_MTYPE_DEL("/api/manager/mtypeDel", "删除回忆录类别"),
    URL_MTYPE_EDIT("/api/manager/mtypeEdit", "修改回忆录类别"),
    URL_PTYPE_ADD("/api/manager/ptypeAdd", "添加照片类别"),
    URL_PTYPE_DEL("/api/manager/ptypeDel", "删除照片类别"),
    URL_PTYPE_EDIT("/api/manager/ptypeEdit", "修改照片类别"),
    URL_GALLERY_UPLOAD("/api/manager/galleryUpload","添加照片"),
    URL_GALLERY_ADD("/api/manager/galleryAdd","添加照片"),
    URL_GALLERY_DEL("/api/manager/galleryDel","删除照片"),
    URL_GALLERY_EDIT("/api/manager/galleryEdit","修改照片"),

    URL_MEMORY_IMAGE("/image/memory/", "回忆录图片"),


    ;


    private String url;
    private String comment;
    private static String baseURL = "http://zleitencent.cn:8001/lover";

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
