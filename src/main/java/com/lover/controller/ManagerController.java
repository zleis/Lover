package com.lover.controller;

import com.lover.entity.URLEnum;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/v/manager")
public class ManagerController {

    private static Logger logger = Logger.getLogger(ManagerController.class);


    @RequestMapping("/login")
    public ModelAndView login(){
        logger.info("/api/manager/login");
        ModelAndView mv = new ModelAndView("manager/login");
        mv.addObject("loginURL", URLEnum.URL_LOGIN.getUrl());
        return mv;
    }

}
