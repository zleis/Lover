package com.lover.service.imp;

import com.lover.dao.ManagerDao;
import com.lover.entity.Feedback;
import com.lover.entity.Manager;
import com.lover.entity.Result;
import com.lover.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImp implements ManagerService {

    @Autowired
    private ManagerDao managerDao;

    @Override
    public Result login(Manager manager) {
        Manager managerSql = managerDao.managerFind(manager.getMid());
        Result result = new Result();
        if(managerSql != null){
            if(managerSql.getPass().equals(manager.getPass())){
                result.setFeedback(Feedback.FEEDBACK_SUCCESS.getFeedback());
                result.setMsg(Feedback.FEEDBACK_SUCCESS.getComment());
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
}
