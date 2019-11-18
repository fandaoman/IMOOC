package com.baidu.handler;

import com.alibaba.druid.support.spring.mvc.StatHandlerInterceptor;
import com.fasterxml.jackson.databind.cfg.HandlerInstantiator;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*
 * @Auther fandaoman
 * @date 2019/11/18 16:35
 * @Ver 1.0
 * @监听用户是否登录，未登录强制跳转
 * */
@Component
public class UserLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        HttpSession session = request.getSession(true);
        Object user = session.getAttribute("user");
        String requestURI = request.getRequestURI();
        //排除登录时的拦截
        if(requestURI.equals("/user/login")){
            return true;
        }
        if(null!=user){
            //已经登录
            return true;
        }else{
            //未登录
            //直接重定向到登录界面
            response.sendRedirect(request.getContextPath()+"/back/login.jsp");
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
