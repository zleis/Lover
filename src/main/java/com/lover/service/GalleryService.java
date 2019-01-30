package com.lover.service;

import com.lover.entity.PType;
import com.lover.entity.Photo;
import com.lover.entity.Result;

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

    /**
     * @Method ptypeAdd
     * @Date 2019/1/28
     * @TODO 添加回忆录类别
     */
    public Result ptypeAdd(PType pType);

    /**
     * @Method ptypeDel
     * @Date 2019/1/28
     * @TODO 删除回忆录类别
     */
    public Result ptypeDel(PType pType);

    /**
     * @Method ptypeEdit
     * @Date 2019/1/28
     * @TODO 修改回忆录类别
     */
    public Result ptypeEdit(PType pType);

    /**
     * @Method ptypeFind
     * @Date 2019/1/28
     * @TODO 回忆录类别查看
     */
    public PType ptypeFind(int mid);


    public Result photoAdd(Photo photo);

    public Result photoDel(Photo photo);

    public Result photoEdit(Photo photo);

}
