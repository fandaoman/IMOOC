package com.baidu.entity;

import java.io.Serializable;
import java.util.Date;

/*
 * @Auther fandaoman
 * @date 2019/11/14 15:46
 * @Ver 1.0
 * @用户头像信息
 * */
public class UserHead implements Serializable {
    private String id;

    private String userId;

    //头像id
    private String head_sculpture_id;

    //图片路径
    private String path;

    //利用标志0：启用 2：弃用
    private String delFlag;

    //上传日期
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHead_sculpture_id() {
        return head_sculpture_id;
    }

    public void setHead_sculpture_id(String head_sculpture_id) {
        this.head_sculpture_id = head_sculpture_id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

}
