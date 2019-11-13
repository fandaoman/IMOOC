package com.baidu.common;

import java.io.Serializable;

/*
 * @Auther fandaoman
 * @date 2019/11/13 11:21
 * @Ver 1.0
 * */
public class Result  {
    private boolean status;

    private String msg;


    public Result failure(boolean bb,String msg){
        Result result = new Result();
        result.setStatus(bb);
        result.setMsg(msg);
        return result;
    }

    public Result success(boolean bb){
        Result result = new Result();
        result.setStatus(bb);
        return result;
    }

    public Result() {
    }

    public Result(boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
