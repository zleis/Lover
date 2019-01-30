package com.lover.dao;

import com.lover.entity.Memory;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @Class: MemoryDao
 * @Author: ZLei
 * @Date: 14:16
 * @TODO: 回忆录
 */
public interface MemoryDao {

    /**
     *
     * @param hashMap
     * @return
     * @Todo 根据类别获取记录列表
     */
    List<Memory> memoryListByType(HashMap hashMap);

    /**
     *
     * @param hashMap
     * @return
     * 获取全部类别列表
     */
    List<Memory> memoryList(HashMap hashMap);
    /**
     *
     * @return
     * @TODO 根据mid获取记录
     */
    Memory memoryFind(@Param("mid")String mid);

    /**
     *
     * @param type 回忆录类别
     * @return 回忆录类别的数量
     */
    int memoryNumByType(@Param("type")int type);


    /**
     *
     * @return 回忆录总长度
     */
    int memoryNum();

    /**
     * @Method memoryAdd
     * @Date 2019/1/26
     * @TODO 添加回忆录
     */
    void memoryAdd(Memory memory);

    /**
     * @Method memoryListType
     * @Date 2019/1/26
     * @TODO 回忆录列表
     */
    List<Memory> memoryListType(HashMap hashMap);

    /**
     * @Method memoryDel
     * @Date 2019/1/26
     * @TODO 删除回忆录
     */
    void memoryDel(Memory memory);

    /**
     * @Method memoryEdit
     * @Date 2019/1/27
     * @TODO 修改回忆录
     */
    void memoryEdit(Memory memory);

}
