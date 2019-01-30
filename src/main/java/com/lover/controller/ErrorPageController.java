package com.lover.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.jws.WebParam;

@Controller
@RequestMapping("/error")
public class ErrorPageController {

    private static Logger logger = Logger.getLogger(ErrorPageController.class);

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public ModelAndView page404(){
        logger.info("/404");
        ModelAndView mv = new ModelAndView("404");
        return mv;
    }

    @RequestMapping(value = "/500", method = RequestMethod.GET)
    public ModelAndView page500(){
        logger.info("/500");
        ModelAndView mv = new ModelAndView("500");
        return mv;
    }
}
