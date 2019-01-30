package com.lover.dao;

import com.lover.entity.Answer;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @Class: AnswerDao
 * @Author: ZLei
 * @Date: 14:16
 * @TODO: 简答数据库
 */
public interface AnswerDao {
    /**
     *
     * @return
     * @TODO 获取简答的数量
     *
     */
    public Integer answerNum();

    /**
     *
     * @param hashMap [start 开始点, length 长度]
     * @return
     * @TODO 获取简答列表
     */
    public List<Answer> answerList(HashMap hashMap);

    /**
     *
     * @param hashMap
     * @return
     * @TODO 通过简答ID获取简答
     */
    public Answer answerFind(HashMap hashMap);

    /**
     * @Method answerAdd
     * @Date 2019/1/20
     * @TODO 添加简答
     */
    public void answerAdd(Answer answer);

    /**
     * @Method answerRead
     * @Date 2019/1/20
     * @TODO 阅读次数自增
     */
    public void answerRead(@Param("aid") String aid);

    /**
     * @Method answerDel
     * @Date 2019/1/24
     * @TODO 简答删除
     */
    public void answerDel(@Param("aid")String aid);

    /**
     * @Method answerEdit
     * @Date 2019/1/24
     * @TODO 修改简答
     */
    public void answerEdit(Answer answer);
}
