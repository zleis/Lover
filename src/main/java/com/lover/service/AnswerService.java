package com.lover.service;

import com.lover.entity.Answer;

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


}
