package com.lover.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/api/manager")
public class ManagerController {

    private static Logger logger = Logger.getLogger(ManagerController.class);
    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response){
        logger.info("/login");
        System.out.println("manager Login");
    }
}
