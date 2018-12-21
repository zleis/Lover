package com.lover.controller.view;

import com.lover.dao.MTypeDao;
import com.lover.dao.MainDao;
import com.lover.dao.MenuDao;
import com.lover.dao.PTypeDao;
import com.lover.entity.*;
import com.lover.service.AnswerService;
import com.lover.service.HostService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by ZLei on 2018/12/2.
 */
@Controller
@RequestMapping("/v/host")
public class HostController{
    private static Logger logger = Logger.getLogger(HostController.class);

    // 页面服务
    @Autowired
    private HostService hostService;

    @Autowired
    private AnswerService answerService;

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request){
        logger.info("/index");
        ModelAndView mv = new ModelAndView( "host/index");

        mv.addObject("message", hostService.getMainList());

        return mv;
    }

    /**
     * @param request
     * requestMap
     * key          mean
     * page    |  the number of page
     *
     * @return
     */
    @RequestMapping("/answer")
    public ModelAndView answer(HttpServletRequest request){
        logger.info("answer");
        ModelAndView mv = new ModelAndView("host/answer");

        Map<String, String> param = (Map<String, String>) request.getParameterMap();

        int page = 0;  //
        if(param.containsKey("page")){
            page = Integer.valueOf(param.get("page"));
        }

        List<Answer> answers = answerService.answerList(page);
        int answerNumber = answerService.answerNumber();
//        int answerPageNumber = Math.ceil((double)answerNumber/(double)Constant.ANSWER_PAGE_NUMBER);



        mv.addObject("menu",hostService.getMenuList());
        return mv;
    }

    @RequestMapping("/memoirs")
    public ModelAndView memoirs(HttpServletRequest request){
        logger.info("/memoirs");
        ModelAndView mv = new ModelAndView("host/memoirs");

        mv.addObject("menu", hostService.getMenuList());
        mv.addObject("mtype", hostService.getMTypeList());
        return mv;
    }


    @RequestMapping("/gallery")
    public ModelAndView gallery(HttpServletRequest request){
        logger.info("/gallery");
        ModelAndView mv = new ModelAndView("host/gallery");

        mv.addObject("menu", hostService.getMenuList());
        mv.addObject("ptype", hostService.getPTypeList());

        return mv;
    }

    // 简答页面



    // 回忆录页面
    @RequestMapping("/memoryitem")
    public ModelAndView memoryItem(HttpServletRequest request){
        logger.info("/memoryItem");
        ModelAndView mv = new ModelAndView("host/memoryItem");

        return mv;
    }

    // 简答条目
    @RequestMapping("/answeritem")
    public ModelAndView answerItem(HttpServletRequest request){
        logger.info("/answerItem");
        ModelAndView mv = new ModelAndView("host/answerItem");


        return mv;
    }



}
