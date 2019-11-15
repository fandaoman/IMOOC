package com.baidu.entity;

/*
 * @Auther fandaoman
 * @date 2019/11/14 15:46
 * @Ver 1.0
 * @用户头像信息
 * */
public class UserHead {
    private String id;

    private String userId;

    //头像id
    private String headSculptureId;

    //图片路径
    private String path;

    //利用标志0：启用 2：弃用
    private String delFlag;

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

    public String getHeadSculptureId() {
        return headSculptureId;
    }

    public void setHeadSculptureId(String headSculptureId) {
        this.headSculptureId = headSculptureId;
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
