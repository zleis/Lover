package com.lover.service;

import com.lover.entity.Message;

import java.util.HashMap;
import java.util.List;

public interface MessageService {

    /**
     *
     * @param page
     * @return
     * @TODO 获取某个页面的留言内容
     */
    public List<Message> messageList(int page);

    /**
     * @return
     * @TODO 获取留言的个数
     */
    public Integer messageNum();


    /**
     * @Todo 添加一条留言
     * @param uid 用户ID
     * @param msg 用户消息
     */
    public void messageAdd(String uid, String msg);
}
