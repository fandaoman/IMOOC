package com.baidu.entity;

import java.util.Date;

/*
 * @Auther fandaoman
 * @date 2019/10/26 20:26
 * @Ver 1.0
 * @用于存储用户信息
 * */
public class User {

    //用户ID标识
    private String id;

    //用户昵称
    private String username;

    //用户姓名
    private String realname;

    //用户年龄
    private Integer age;

    //用户性别
    private String sex;

    //MD5加密后的密码
    private String password;

    //用户手机号
    private String tel;

    //用户地址ID
    private String addressId;

    //注册信息时间
    private Date createTime;

    //删除标识 0:启用  1：逻辑删除
    private String delFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public User() {
    }

    public User(String id, String username, String realname, Integer age, String sex, String password, String tel, String addressId, Date createTime, String delFlag) {
        this.id = id;
        this.username = username;
        this.realname = realname;
        this.age = age;
        this.sex = sex;
        this.password = password;
        this.tel = tel;
        this.addressId = addressId;
        this.createTime = createTime;
        this.delFlag = delFlag;
    }
}
