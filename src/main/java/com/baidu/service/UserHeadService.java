package com.baidu.service;

import com.baidu.entity.UserHead;

public interface UserHeadService {
    //1:头像的上传
    void add(UserHead userHead);
    //2：头像的修改
    void update(UserHead userHead);
    //3：头像的删除
    void delete(String id);
    //4:头像的查询
    UserHead findOne(String userId);
}
