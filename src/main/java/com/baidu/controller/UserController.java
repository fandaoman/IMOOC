package com.baidu.controller;

import com.baidu.common.Response;
import com.baidu.common.Result;
import com.baidu.entity.User;
import com.baidu.service.UserService;
import com.baidu.utils.MD5Utils;
import org.apache.tomcat.websocket.WsSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/*
 * @Auther fandaoman
 * @date 2019/10/26 22:24
 * @Ver 1.0
 * */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    //用户登录

    @RequestMapping(value = "/login")@ResponseBody
    public Result userLogin(String username, String password,
                            HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        Result result=new Result();
        if("".equals(username) || "".equals(password)){

           return result.failure(false,"用户名或密码不能为空");
        }else{
            User user = userService.findByUsername(username);
            //反向解析MD5密码
            if(user!=null && !password.isEmpty()){
                if(user.getPassword().equals(MD5Utils.getMD5(password))){
                    //将用户信息储存到session中
                    HttpSession session = request.getSession();
                    session.setAttribute("realname",user.getRealname());
                    session.setAttribute("userId",user.getId());
                    return result.success(true);
                }
                return result.failure(false,"用户名或密码错误");
            }
        }
        return result;
    }

    //用户信息的注册
    @RequestMapping("/redister")
    public void userRegister(String username,String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userService.add(user);
    }

    //用户信息修改
    public void userUpdate(User user,String id){}

    //用户信息逻辑删除
    public void userDelete(String id){}

    //查询所有用户信息
    @RequestMapping("/findAll")
    public List<User> findAll(){
        List<User> users = userService.FindAll();
        return users;
    }
}
