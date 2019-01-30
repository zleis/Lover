package com.lover.service.imp;

import com.lover.dao.AnswerDao;
import com.lover.dao.ManagerDao;
import com.lover.entity.Answer;
import com.lover.entity.Feedback;
import com.lover.entity.Manager;
import com.lover.entity.Result;
import com.lover.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class ManagerServiceImp implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    @Autowired
    private AnswerDao answerDao;

    @Override
    public Result login(Manager manager) {
        Manager managerSql = managerDao.managerFind(manager.getMid());
        Result result = new Result();
        if(managerSql != null){
            if(managerSql.getPass().equals(manager.getPass())){
                result.setFeedback(Feedback.FEEDBACK_SUCCESS.getFeedback());
                result.setMsg(Feedback.FEEDBACK_SUCCESS.getComment());
                result.setObj(managerSql);
            }else{
                result.setFeedback(Feedback.FEEDBACK_PASS_ERROR.getFeedback());
                result.setMsg(Feedback.FEEDBACK_PASS_ERROR.getComment());
            }
        }else{
            result.setFeedback(Feedback.FEEDBACK_USER_NO_EXIT.getFeedback());
            result.setMsg(Feedback.FEEDBACK_USER_NO_EXIT.getComment());
        }
        result.setObj(managerSql);
        return result;
    }

    @Override
    public Result infoEdit(String mid, String oldpass, String newpass) {
        Manager manager = managerDao.managerFind(mid);
        if(oldpass.equals(manager.getPass())){
            managerDao.managerEdit(manager.getMid(), newpass);
            return Result.resultFactory(Feedback.FEEDBACK_SUCCESS);
        }else{
            return Result.resultFactory(Feedback.FEEDBACK_PASS_ERROR);
        }
    }
}
