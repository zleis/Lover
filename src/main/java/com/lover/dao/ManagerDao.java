package com.lover.dao;

import com.lover.entity.Manager;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @class: ManagerDao
 * @date: 2018/11/19
 * @author: zlei
 *
 */
@Repository
public interface ManagerDao {

    /**
     * @Method managerFind
     * @Date 2019/1/6
     * @TODO 查找管理员
     */
    public Manager managerFind(@Param("mid")String mid);


    public void managerEdit(@Param("mid")String mid, @Param("pass")String pass);

}
