package com.lover.service;

import com.lover.entity.Answer;
import com.lover.entity.Manager;
import com.lover.entity.Result;

/**
 * Created by ZLei on 2018/11/19.
 */
public interface ManagerService {



    /**
     * @Method login
     * @Date 2019/1/6
     * @TODO 用户登录
     */
    public Result login(Manager manager);

    /**
     * @Method infoEdit
     * @Date 2019/1/27
     * @TODO 用户个人信息更新
     */
    public Result infoEdit(String mid, String oldpass, String newpass);

}
