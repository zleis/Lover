package com.lover.dao;

import com.lover.entity.MType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MTypeDao {

    /**
     * @Method getMtypeList
     * @Date 2019/1/28
     * @TODO 获取MType列表
     */
    List<MType> getMTypeList();

    /**
     * @Method mtypeFind
     * @Date 2019/1/28
     * @TODO 查看mtype
     */
    public MType mtypeFind(@Param("mid")int mid);

    /**
     * @Method mtypeAdd
     * @Date 2019/1/28
     * @TODO 添加回忆录类别
     */
    public void mtypeAdd(MType mType);

    /**
     * @Method mtypeDel
     * @Date 2019/1/28
     * @TODO 删除回忆录类别
     */
    public void mtypeDel(MType mType);

    /**
     * @Method mtypeEdit
     * @Date 2019/1/28
     * @TODO 修改回忆录类别
     */
    public void mtypeEdit(MType mType);
}
