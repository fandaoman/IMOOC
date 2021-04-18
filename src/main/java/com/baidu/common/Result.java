package com.baidu.common;

/*
 * @Auther fandaoman
 * @date 2019/11/13 11:21
 * @Ver 1.0
 * */
public class Result<T>  {
    private boolean status;
    private String code;

    private String msg;

    private T dada;

    public Result() {}

    private Result(boolean status) {
        this.status = status;
    }

    private Result(boolean status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    private Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private Result(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.dada = data;
    }

    public Result failure(boolean status, String msg){
        return new Result(status, msg);
    }

    public Result failure(String code, String msg){
        return new Result(code, msg);
    }

    public Result<T> success(String code, String msg, T data){
        return new Result<>(code ,msg ,data);
    }

    public static Result success(String code, String msg){
        return new Result(code, msg);
    }
    public Result success(boolean status) {
        return new Result(status);
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getDada() {
        return dada;
    }

    public void setDada(T dada) {
        this.dada = dada;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
