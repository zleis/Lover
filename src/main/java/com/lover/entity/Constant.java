package com.lover.entity;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

public class Constant {

    public static final int ANSWER_PAGE_NUMBER = 10;    // 每页的简答个数
    public static final int MEMORY_PAGE_NUMBER = 10;    // 每页的回忆录个数
    public static final int PHOTO_PAGE_NUMBER = 30;     // 每页的照片个数
    public static final int MESSAGE_PAGE_NUMBER = 30;   // 每页的留言数量

    public static final int MEMORY_ALL_TYPE = 0;   // 回忆录全部类别
    public static final int PHOTO_ALL_TYPE  = 0;   // 照片全部类别


    public static final int LOGIN_CONDITION = 1;    // 登录状态
    public static final int LOGOUT_CONDITION = 0;


    public static final int ANSWER_INTRO_LENGTH = 20;   // 简答简介长度

    public static final String galleryImage = "/lover/image/gallery/";

    public static String classpath;

    public static String memoryPath;

    public static String galleryPath;

    static {
        try {
            classpath = ResourceUtils.getURL("classpath:").getPath();
            memoryPath = classpath + "static/image/memory/";
            galleryPath = classpath + "static/image/gallery/";
            File memoryFile = new File(memoryPath);
            if(!memoryFile.exists()){
                memoryFile.mkdir();
            }

            File galleryFile = new File(galleryPath);
            if(!galleryFile.exists()){
                galleryFile.mkdir();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
