package com.baidu.service.impl;

import com.baidu.dao.UserDao;
import com.baidu.entity.User;
import com.baidu.service.UserService;
import com.baidu.utils.MD5Utils;
import com.baidu.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/*
 * @Auther fandaoman
 * @date 2019/10/26 20:34
 * @Ver 1.0
 * */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    //注入dao
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> FindAll() {

        List<User> users = userDao.FindAll();
        return users;
    }

    @Override
    public User findOne(String id) {
        User user = userDao.findOne(id);
        return user;
    }

    @Override
    public User findByUsername(String username) {
        User user = userDao.findByUsername(username);
        return user;
    }

    @Override
    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }

    //用户信息的注册
    @Override
    public void add(User user) {


        user.setId(UUIDUtils.getUUID());
        //加密后的密码
        user.setPassword(MD5Utils.getMD5(user.getPassword()));
        //启用标识
        user.setDelFlag("0");
        //关联的地址ID暂时为空
        user.setAddressId(null);
        user.setCreateTime(new Date());
        user.setSex("0");
        user.setAge(18);
        user.setTel("18500054926");
        userDao.add(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
}
