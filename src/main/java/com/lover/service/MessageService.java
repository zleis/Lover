package com.lover.service;

import com.lover.entity.Message;
import com.lover.entity.Result;

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
     */
    public Result messageAdd(Message message);

    /**
     * @Method messageDel
     * @Date 2019/1/27
     * @TODO 删除消息
     */
    public Result messageDel(Message message);
}
