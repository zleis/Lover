package com.lover.service.imp;

import com.lover.dao.MessageDao;
import com.lover.entity.Constant;
import com.lover.entity.Feedback;
import com.lover.entity.Message;
import com.lover.entity.Result;
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
    public Result messageAdd(Message message) {
        message.init();
        message.format();
        System.out.println(message.toString());
        messageDao.messageAdd(message);
        return Result.resultFactory(Feedback.FEEDBACK_SUCCESS);
    }

    @Override
    public Result messageDel(Message message) {
        messageDao.messageDel(message.getMid());
        return Result.resultFactory(Feedback.FEEDBACK_SUCCESS);
    }
}
