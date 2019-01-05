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



}
