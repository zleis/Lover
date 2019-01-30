package com.lover.dao;

import com.lover.entity.Photo;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @Class PhotoDao
 * @TODO 照片数据库
 */
public interface PhotoDao {

    /**
     *
     * @param hashMap
     * @return
     * 获取照片列表，按照类别
     */
    public List<Photo> photoListByType(HashMap hashMap);

    /**
     *
     * @param hashMap
     * @return
     * @Todo 获取照片列表（全类别）
     */
    public List<Photo> photoList(HashMap hashMap);

    /**
     * @Todo 获取某个类别的照片熟数量
     */
    public Integer photoNumberByType(@Param("type") int type);

    /**
     * @Todo 获取全部类别的照片数量
     */
    public Integer photoNumber();


    /**
     *
     * @param pid
     * @return
     * @TODO 获取照片详情
     */
    public Photo photoFind(@Param("pid")String pid);

    /**
     * @Method photoAdd
     * @Date 2019/1/30
     * @TODO 添加图片
     */
    public void photoAdd(Photo photo);

    /**
     * @Method photoEdit
     * @Date 2019/1/30
     * @TODO 修改照片
     */
    public void photoEdit(Photo photo);

    /**
     * @Method photoDel
     * @Date 2019/1/30
     * @TODO 删除图片
     */
    public void photoDel(Photo photo);

}
