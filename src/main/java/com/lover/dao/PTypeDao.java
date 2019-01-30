package com.lover.dao;

import com.lover.entity.MType;
import com.lover.entity.PType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PTypeDao {

    List<PType> getPTypeList();


    /**
     * @Method mtypeFind
     * @Date 2019/1/28
     * @TODO 查看mtype
     */
    public PType ptypeFind(@Param("pid")int pid);

    /**
     * @Method ptypeAdd
     * @Date 2019/1/28
     * @TODO 添加回忆录类别
     */
    public void ptypeAdd(PType pType);

    /**
     * @Method ptypeDel
     * @Date 2019/1/28
     * @TODO 删除回忆录类别
     */
    public void ptypeDel(PType pType);

    /**
     * @Method ptypeEdit
     * @Date 2019/1/28
     * @TODO 修改回忆录类别
     */
    public void ptypeEdit(PType pType);
}
