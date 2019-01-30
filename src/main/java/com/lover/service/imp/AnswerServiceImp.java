package com.lover.service.imp;

import com.lover.dao.AnswerDao;
import com.lover.entity.Answer;
import com.lover.entity.Constant;
import com.lover.entity.Feedback;
import com.lover.entity.Result;
import com.lover.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AnswerServiceImp implements AnswerService {

    @Autowired
    private AnswerDao answerDao;

    @Override
    public List<Answer> answerList(int page) {
        HashMap map = new HashMap();
        map.put("start",page * Constant.ANSWER_PAGE_NUMBER);
        map.put("length", Constant.ANSWER_PAGE_NUMBER);
        return answerDao.answerList(map);
    }

    @Override
    public int answerNumber() {
        return answerDao.answerNum();
    }


    @Override
    public Answer answerFind(String aid) {
        HashMap map = new HashMap();
        map.put("aid", aid);
        Answer answer = answerDao.answerFind(map);
        answerDao.answerRead(aid);
        return answer;
    }
    @Override
    public Result answerAdd(Answer answer) {
        answerDao.answerAdd(answer);
        return Result.resultFactory(Feedback.FEEDBACK_SUCCESS);
    }

    @Override
    public Result answerDel(Answer answer) {
        answerDao.answerDel(answer.getAid());
        return Result.resultFactory(Feedback.FEEDBACK_SUCCESS);
    }

    @Override
    public Result answerEdit(Answer answer) {
        answerDao.answerEdit(answer);
        return Result.resultFactory(Feedback.FEEDBACK_SUCCESS);
    }
}
