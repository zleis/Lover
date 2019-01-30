package com.lover.dao;

import com.lover.entity.Message;
import org.apache.ibatis.annotations.Param;

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
     * 添加消息
     */
    public void messageAdd(Message message);

    /**
     * @Method messageDel
     * @Date 2019/1/27
     * @TODO 删除消息
     */
    public void messageDel(@Param("mid")String mid);



}
