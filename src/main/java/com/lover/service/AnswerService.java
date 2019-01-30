package com.lover.service;

import com.lover.entity.Answer;
import com.lover.entity.Result;

import java.util.List;

public interface AnswerService {

    /**
     *
     * @param page
     * @return
     * @todo 获取简答列表
     */
    public List<Answer> answerList(int page);

    /**
     * @return
     * @Todo 获取简答的数量
     */
    public int answerNumber();

    /**
     *
     * @param aid
     * @return
     * @TODO 通过简答ID查找简答
     */
    public Answer answerFind(String aid);

    /**
     * @Method answerAdd
     * @Date 2019/1/20
     * @TODO 添加简答
     */
    public Result answerAdd(Answer answer);

    /**
     * @Method answerDel
     * @Date 2019/1/24
     * @TODO 删除简答
     */
    public Result answerDel(Answer answer);
    
    /**
     * @Method answerEdit
     * @Date 2019/1/24
     * @TODO 修改简答
     */
    public Result answerEdit(Answer answer);


    


}
