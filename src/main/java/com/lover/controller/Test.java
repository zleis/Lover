package com.lover.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Created by ZLei on 2018/11/12.
 */
@Controller
@RequestMapping("/Test")
public class Test {
    private final static Logger logger = LoggerFactory.getLogger(Test.class);

    @RequestMapping(value = "/index")
    public String testLog(){
        logger.info("test");
        logger.debug("test debug");
        logger.error("test error");
        return "test/index";
    }
}
