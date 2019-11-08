package com.baidu.dao;

import com.baidu.entity.User;

import java.util.List;

public interface UserDao {
    //1.查询所有用户信息
    List<User> FindAll();
    //2.根据ID查询一个用户信息
    User findOne(String id);
    //3.根据用户名查询用户信息
    User findByUsername(String username);
    //4.根据ID删除用户信息
    void deleteUser(String id);
    //5.根据用户ID更新用户信息
    void updateUser(User user);
    //6.用户信息注册
    void add(User user);
}
