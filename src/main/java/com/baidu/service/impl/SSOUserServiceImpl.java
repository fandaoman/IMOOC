package com.baidu.service.impl;

import com.alibaba.fastjson.JSON;
import com.baidu.common.Result;
import com.baidu.dao.UserDao;
import com.baidu.entity.User;
import com.baidu.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Author: FDM
 * @Date: 2021/4/17 11:53
 * @Version 1.0
 */
@Service
@Transactional
@PropertySource(value = "classpath:redis.properties")
public class SSOUserServiceImpl {
    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisUtil redisUtil;

    @Value("${REDIS_USER_SESSION_KEY}")
    private String RESID_USER_SESSION_KEY;

    @Value("${SSO_SESSION_EXPIRE}")
    private Integer SSO_SESSION_EXPIRE;

    public void registerUser(User user) {
        // 检查用户是否注册，一般在前端验证的时候处理，注册不存在高并发的情况，这里再加一层不影响性能
        if (null != userDao.findByUsername(user.getUsername())) {
            // 返回状态值
        }
        userDao.add(user);
        // 注册成功之后选择发送邮件激活，现在是短信验证
        // 饭后状态值
    }

    public Result userLogin(String account, String password,
                          HttpServletRequest request, HttpServletResponse response) {
        // 判断账号密码是否正确
        User user = userDao.findByUsername(account);
        if(user == null){
            return new Result().success("400", "账号名或密码错误");
        }
        /*if (!CheckUtils.decryptPassword(user, password)) {
            //return Result.build(400, "账号名或密码错误");
        }*/
        // 生成token
        String token = UUID.randomUUID().toString();
        // 清空密码和盐避免泄漏
        String userPassword = user.getPassword();
        String userSalt = "";//user.getSalt();
        user.setPassword(null);
        //user.setSalt(null);
        // 把用户信息写入 redis
        redisUtil.set(RESID_USER_SESSION_KEY + ":" + token, JSON.toJSON(user));
        // user 已经是持久化对象了，被保存在了session缓存当中，若user又重新修改了属性值，那么在提交事务时，此时 hibernate对象就会拿当前这个user对象和保存在session缓存中的user对象进行比较，如果两个对象相同，则不会发送update语句，否则，如果两个对象不同，则会发出update语句。
        user.setPassword(userPassword);
        //user.setSalt(userSalt);
        // 设置 session 的过期时间
        redisUtil.expire(RESID_USER_SESSION_KEY + ":" + token, SSO_SESSION_EXPIRE);
        // 添加写 cookie 的逻辑，cookie 的有效期是关闭浏览器就失效。
        //CookieUtils.setCookie(request, response, "USER_TOKEN", token);
        // 返回token
        return new Result().success("200", "success", token);
    }
}
