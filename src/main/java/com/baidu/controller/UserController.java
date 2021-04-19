package com.baidu.controller;

import com.baidu.common.YZResponse;
import com.baidu.entity.User;
import com.baidu.entity.UserHead;
import com.baidu.service.UserHeadService;
import com.baidu.service.UserService;
import com.baidu.utils.MD5Utils;
import org.apache.poi.ss.formula.functions.T;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @Auther fandaoman
 * @date 2019/10/26 22:24
 * @Ver 1.0
 * */
@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //用户头像信息
    @Autowired
    private UserHeadService userHeadService;
    //用户登录

    @RequestMapping(value = "/login")@ResponseBody
    public YZResponse userLogin(String username, String password,
                                   HttpServletRequest request) {
        if("".equals(username) || "".equals(password)){
           return YZResponse.error(500,"用户名或密码不能为空");
        }else{
            User user = userService.findByUsername(username);
            //反向解析MD5密码
            if(user!=null && !password.isEmpty()){
                if(user.getPassword().equals(MD5Utils.getMD5(password))){
                    //将用户信息储存到session中
                    HttpSession session = request.getSession();
                    session.setAttribute("user",user);
                    //查询此人头像
                    UserHead userhead = userHeadService.findOne(user.getId());
                    //将此人正在使用的头像存储到session中
                    session.setAttribute("userHead",userhead);
                    return YZResponse.success(true);
                }
                return YZResponse.error(401,"用户名或密码错误");
            }
        }
        return YZResponse.success(true);
    }
    @RequestMapping(value = "/shirologin")@ResponseBody
    public YZResponse userLogin2(String username, String password,
                            HttpServletRequest request) {
        //获取主体对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username , password));
        } catch (UnsupportedOperationException ex){
            return YZResponse.error(401,"用户名错误");
        } catch (IncorrectCredentialsException ex){
            return YZResponse.error(401,"密码错误");
        }

        return YZResponse.success(true);
    }
    //用户信息的注册
    @RequestMapping(value = "/register")@ResponseBody
    public YZResponse userRegister(String username,String password,String email,String realname){
        if (username.isEmpty() || password.isEmpty() || email.isEmpty() || realname.isEmpty()){
             return YZResponse.error(401,"注册信息有误");
        }else{
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setRealname(realname);
            user.setPassword(password);
            userService.add(user);
            return YZResponse.success(true);
        }
    }

    //用户信息修改
    public void userUpdate(User user,String id){}

    //用户信息逻辑删除
    public void userDelete(String id){}

    //查询所有用户信息
    @RequestMapping("/findAll")
    public List<User> findAll(){
        List<User> users = userService.FindAll();
        if(users.size()>0){
            return users;
        }else{
            return null;
        }
    }

    @RequestMapping("/findOne")
    public Map<Object,Object> findOne(HttpServletRequest request){
        Map<Object, Object> map = new HashMap<>();
        User admin =(User) request.getAttribute("user");
        if (admin==null){
            map.put("result",new YZResponse<T>(401, "登录失效，请重新登录"));
        }else{
            userService.findOne(admin.getId());
        }
        return map;
    }
}
