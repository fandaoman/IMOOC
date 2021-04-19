package com.baidu.controller;

import com.baidu.common.YZResponse;
import com.baidu.service.impl.SSOUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/sso/user")
public class SSOUserController {
    @Autowired
    private SSOUserService ssoUserService;


    @PostMapping("/login")
    public void userLogin(String username, String password, HttpServletRequest request,
                          HttpServletResponse response) {
        try {
            YZResponse result = ssoUserService.userLogin(username, password, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value="/logout/{token}")
    public String logout(@PathVariable String token) {
        ssoUserService.logout(token); // 思路是从Redis中删除key，实际情况请和业务逻辑结合
        return "index";
    }

    @RequestMapping("/token/{token}")
    @ResponseBody
    public Object getUserByToken(@PathVariable String token) {
        YZResponse result = null;
        try {
            result = ssoUserService.queryUserByToken(token);
        } catch (Exception e) {
            e.printStackTrace();
            result = YZResponse.error("500", "");
        }
        return result;
    }
}
