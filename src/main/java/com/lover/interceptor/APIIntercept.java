package com.lover.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.lover.entity.Constant;
import com.lover.entity.Feedback;
import com.lover.entity.Result;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;

/**
 * @Class APIIntercept
 * @Author ZLei
 * @Date 2019/1/20
 * @TODO 请求拦截器
 */
public class APIIntercept implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        PrintWriter writer =  response.getWriter();
        JSONObject jsonObject = new JSONObject();
        if(session.getAttribute("login") != null && (Integer)session.getAttribute("login") == Constant.LOGIN_CONDITION){
            return true;
        }else{
            jsonObject.put("feedback",Feedback.FEEDBACK_WITHOUT_LOGIN.getFeedback());
            jsonObject.put("msg",Feedback.FEEDBACK_WITHOUT_LOGIN.getComment());
            writer.write(jsonObject.toString());
            writer.close();
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
