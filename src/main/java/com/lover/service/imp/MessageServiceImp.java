package com.lover.service.imp;

import com.lover.dao.MessageDao;
import com.lover.entity.Constant;
import com.lover.entity.Message;
import com.lover.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MessageServiceImp implements MessageService {

    @Autowired
    private MessageDao messageDao;
    @Override
    public List<Message> messageList(int page) {
        HashMap hashMap = new HashMap();
        hashMap.put("start", page * Constant.MESSAGE_PAGE_NUMBER);
        hashMap.put("length", Constant.MESSAGE_PAGE_NUMBER);
        return messageDao.messageList(hashMap);
    }

    @Override
    public Integer messageNum() {
        return messageDao.messageNum();
    }

    @Override
    public void messageAdd(String uid, String msg) {

    }
}
