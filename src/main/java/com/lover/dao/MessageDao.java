package com.lover.dao;

import com.lover.entity.Message;

import java.util.HashMap;
import java.util.List;

public interface MessageDao {

    /**
     *
     * @param hashMap
     * @return
     * 查看消息列表
     */
    public List<Message> messageList(HashMap hashMap);

    /**
     *
     * @return
     * 获取消息的总共个数
     */
    public Integer messageNum();

    /**
     *
     * @param hashMap
     * 添加消息
     */
    public void messageAdd(HashMap hashMap);
}
