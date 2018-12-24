package com.lover.service;

import com.lover.entity.Memory;

import java.util.List;

public interface MemoryService {

    /**
     *
     * @param type
     * @return
     * @Todo 根据类别获取列表
     */
    public List<Memory> memoryListByType(int type, int start, int length);

    /**
     * @return
     * @Todo 获取回忆录详细列表
     */
    public Memory memoryFind(int mid);

    /**
     * @param type 类别
     * @return 该类别回忆录的长度
     */
    public int memoryLength(int type);
}
