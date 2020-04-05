package com.baidu.entity;

import java.util.Date;

/**
 * @Author: FDM
 * @Date: 2020/4/4 15:04
 * @Version 1.0
 * @introduce 双色球实体类
 */
public class Lottery {
    private String id;

    private String redNumberOne;

    private String redNumberTwo;

    private String redNumberThree;

    private String redNumberThour;

    private String redNumberFive;

    private String redNumberSix;

    private String blueOne;

    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRedNumberOne() {
        return redNumberOne;
    }

    public void setRedNumberOne(String redNumberOne) {
        this.redNumberOne = redNumberOne;
    }

    public String getRedNumberTwo() {
        return redNumberTwo;
    }

    public void setRedNumberTwo(String redNumberTwo) {
        this.redNumberTwo = redNumberTwo;
    }

    public String getRedNumberThree() {
        return redNumberThree;
    }

    public void setRedNumberThree(String redNumberThree) {
        this.redNumberThree = redNumberThree;
    }

    public String getRedNumberThour() {
        return redNumberThour;
    }

    public void setRedNumberThour(String redNumberThour) {
        this.redNumberThour = redNumberThour;
    }

    public String getRedNumberFive() {
        return redNumberFive;
    }

    public void setRedNumberFive(String redNumberFive) {
        this.redNumberFive = redNumberFive;
    }

    public String getRedNumberSix() {
        return redNumberSix;
    }

    public void setRedNumberSix(String redNumberSix) {
        this.redNumberSix = redNumberSix;
    }

    public String getBlueOne() {
        return blueOne;
    }

    public void setBlueOne(String blueOne) {
        this.blueOne = blueOne;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
