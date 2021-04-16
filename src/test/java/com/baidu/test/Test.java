package com.baidu.test;

import com.baidu.YZApplication;
import com.baidu.entity.User;
import com.baidu.service.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @Auther fandaoman
 * @date 2019/10/28 9:04
 * @Ver 1.0
 * */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = YZApplication.class)
public class Test {

    @Autowired
    private UserService userService;
    @org.junit.Test
    public void getUser(){

        List<User> users = userService.FindAll();
        System.out.println(users);
    }

    @org.junit.Test
    public void addUser(){
        User user = new User();
        user.setAddressId("111");
        user.setAge(18);
        user.setCreateTime(new Date());
        user.setId("2222");
        user.setPassword("mima");
        user.setRealname("fandaoman");
        user.setSex("1");
        user.setUsername("fandaoman");
        user.setTel("18500054926");
        System.out.println(user.getRealname());
        userService.add(user);
    }
    @org.junit.Test
    public void ddd(){
        String str1 = "通话";

        String str2 = "重地";

        System.out.println(str1.hashCode() + " " + str2.hashCode());
        List<User> list = new ArrayList<>();
        List emptyList = Collections.EMPTY_LIST;
        list.remove(0);
        list.stream().filter(s -> s.getId().equals("2")).collect(Collectors.toSet());
    }
}
