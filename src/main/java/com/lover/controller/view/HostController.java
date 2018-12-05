package com.lover.controller.view;

import com.lover.dao.MainDao;
import com.lover.entity.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZLei on 2018/12/2.
 */
@Controller
@RequestMapping("/v/host")
public class HostController{
    private static Logger logger = Logger.getLogger(HostController.class);

    @Autowired
    private MainDao mainDao;

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response){
        logger.info("/index");

        ModelAndView mv = new ModelAndView("host/index");
//        List<Main> mains = mainDao.getMainList();
        return mv;
    }

}
