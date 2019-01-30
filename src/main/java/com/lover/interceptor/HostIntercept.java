package com.lover.interceptor;


import com.lover.service.HostService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Class HostIntercept
 * @Author ZLei
 * @Date 2019/1/14
 * @TODO 主页面拦截器，设置公共菜单
 */
public class HostIntercept implements HandlerInterceptor {

    @Autowired
    private HostService hostService;

    private static Logger logger = Logger.getLogger(HostIntercept.class);
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("[HostIntercept] => perHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        logger.info("[HostIntercept] => postHandle");
        modelAndView.addObject("menu", hostService.getMenuList());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
