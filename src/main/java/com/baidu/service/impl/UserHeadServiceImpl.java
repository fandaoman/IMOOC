package com.baidu.service.impl;

import com.baidu.dao.UserHeadDao;
import com.baidu.entity.UserHead;
import com.baidu.service.UserHeadService;
import com.baidu.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

/*
 * @Auther fandaoman
 * @date 2019/11/15 17:13
 * @Ver 1.0
 * */
@Service
@Transactional
public class UserHeadServiceImpl implements UserHeadService {
    @Autowired
    private UserHeadDao userHeadDao;
    @Override
    public void add(UserHead userHead) {
        //本次上传头像的唯一标识id
        userHead.setId(UUIDUtils.getUUID());
        //利用标志默认为0 启用状态
        userHead.setDelFlag("0");
        //上传日期
        userHead.setCreateTime(new Date());
        userHeadDao.add(userHead);
    }

    @Override
    public void update(UserHead userHead) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public UserHead findOne(String userId) {
        return null;
    }
}
