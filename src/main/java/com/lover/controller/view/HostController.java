package com.lover.controller.view;

import com.lover.dao.MainDao;
import com.lover.dao.MenuDao;
import com.lover.entity.Main;
import com.lover.entity.Menu;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * Created by ZLei on 2018/12/2.
 */
@Controller
@RequestMapping("/v/host")
public class HostController{
    private static Logger logger = Logger.getLogger(HostController.class);

    @Autowired
    private MainDao mainDao;

    @Autowired
    private MenuDao menuDao;

    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request){
        logger.info("/index");
        ModelAndView mv = new ModelAndView( "host/index");

        List<Main> mains = mainDao.getMainList();
        for(Main main: mains){
            logger.info(main.toString());
        }

        mv.addObject("message", mains);
        mv.getModel().put("key", mains);
        mv.getModel().put("key1", 1);
        return mv;
    }

    @RequestMapping("/memoirs")
    public ModelAndView list_pic(HttpServletRequest request){
        logger.info("/memoirs");
        ModelAndView mv = new ModelAndView("host/memoirs");
        List<Menu> menus = menuDao.getMenuList();
        mv.addObject("menu", menus);
        return mv;
    }



}
