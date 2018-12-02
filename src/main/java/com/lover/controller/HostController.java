package com.lover.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ZLei on 2018/12/2.
 */
@Controller
@RequestMapping("/v/host")
public class HostController{
    private static Logger logger = Logger.getLogger(HostController.class);

    @RequestMapping("/index")
    public String index(HttpServletRequest request, HttpServletResponse response){
        logger.info("/index");
        return "host/index";
    }

}
