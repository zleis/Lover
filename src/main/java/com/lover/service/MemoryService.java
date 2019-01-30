package com.lover.service;

import com.lover.entity.MType;
import com.lover.entity.Memory;
import com.lover.entity.Message;
import com.lover.entity.Result;

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
    public Memory memoryFind(String mid);

    /**
     * @param type 类别
     * @return 该类别回忆录的长度
     */
    public int memoryLength(int type);

    /**
     * @Method memoryAdd
     * @Date 2019/1/26
     * @TODO 添加回忆录
     */
    public Result memoryAdd(Memory memory);

    /**
     *
     * @param page
     * @return
     * @TODO 返回回忆录包括类别
     */
    public List<Memory> momoryListType(int page);
    
    /**
     * @Method memoryDel
     * @Date 2019/1/26
     * @TODO 删除回忆录
     */
    public Result memoryDel(Memory memory);

    /**
     * @Method memoryEdit
     * @Date 2019/1/27
     * @TODO 回忆录修改
     */
    public Result memoryEdit(Memory memory);

    /**
     * @Method mtypeAdd
     * @Date 2019/1/28
     * @TODO 添加回忆录类别
     */
    public Result mtypeAdd(MType mType);

    /**
     * @Method mtypeDel
     * @Date 2019/1/28
     * @TODO 删除回忆录类别
     */
    public Result mtypeDel(MType mType);

    /**
     * @Method mtypeEdit
     * @Date 2019/1/28
     * @TODO 修改回忆录类别
     */
    public Result mtypeEdit(MType mType);

    /**
     * @Method mtypeFind
     * @Date 2019/1/28
     * @TODO 回忆录类别查看
     */
    public MType mtypeFind(int mid);
}
