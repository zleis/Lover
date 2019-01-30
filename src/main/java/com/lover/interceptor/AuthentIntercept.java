package com.lover.interceptor;

import com.lover.entity.Constant;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * @Class AuthentIntercept
 * @Author ZLei
 * @Date 2019/1/14
 * @TODO 身份验证拦截器
 */
public class AuthentIntercept implements HandlerInterceptor {
    
    /**
     * @Method preHandle
     * @Date 2019/1/14
     * @TODO 执行与Handler方法之前，用于身份验证
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    /**
     * @Method postHandle
     * @Date 2019/1/14
     * @TODO 执行于进入Handler方法之后，返回modelAndView之前执行，应用场景从modelAndView出发：将公用的模型数据(比如菜单导航)在这里
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("login") != null && (Integer)session.getAttribute("login") == Constant.LOGIN_CONDITION){


        }else{
            response.sendRedirect(request.getContextPath() + "/v/manager/login");
        }
    }

    /**
     * @Method afterCompletion
     * @Date 2019/1/14
     * @TODO 执行Handler完成执行此方法, 一般用于异常处理，日志处理
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
