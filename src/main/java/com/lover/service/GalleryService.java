package com.lover.service;

import com.lover.entity.Photo;

import java.util.List;

public interface GalleryService {

    /**
     *
     * @param type 照片类别
     * @param page 照片
     * @return
     */
    public List<Photo> photoList(int type, int page);

    /**
     *
     * @param pid 照片ID
     * @return 照片的详细信息
     */
    public Photo photoFind(String pid);


    /**
     *
     * @param type
     * @return 根据类别获取照片类别数量
     */
    public int photoNumber(int type);

}
