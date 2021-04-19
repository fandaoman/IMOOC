package com.baidu.common;

import com.baidu.enumerate.MessageEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

/**
 * 事件响应返回
 *
 */
public class YZResponse<T> implements Serializable {

    private final int status;
    private String msg;
    private T data;

    private YZResponse(int status) {
        this.status = status;
    }

    private YZResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    private YZResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public YZResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }


    /**
     * 使之不在json序列化结果当中
     *
     * @return boolean boolean
     */
    @JsonIgnore
    public boolean isSuccess() {
        return this.status == MessageEnum.SUCCESS.getCode();
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * Gets data.
     *
     * @return the data
     */
    public T getData() {
        return data;
    }

    /**
     * Gets msg.
     *
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }


    /**
     * Create by success server response.
     *
     * @param <T> the type parameter
     * @return the server response
     */
    public static <T> YZResponse<T> success() {
        return new YZResponse<T>(MessageEnum.SUCCESS.getCode());
    }

    /**
     * Create by success message server response.
     *
     * @param <T> the type parameter
     * @param msg the msg
     * @return the server response
     */
    public static <T> YZResponse<T> successMessage(String msg) {
        return new YZResponse<T>(MessageEnum.SUCCESS.getCode(), msg);
    }

    /**
     * Create by success server response.
     *
     * @param <T>  the type parameter
     * @param data the data
     * @return the server response
     */
    public static <T> YZResponse<T> success(T data) {
        return new YZResponse<T>(MessageEnum.SUCCESS.getCode(), data);
    }

    /**
     * Create by success server response.
     *
     * @param <T>  the type parameter
     * @param msg  the msg
     * @param data the data
     * @return the server response
     */
    public static <T> YZResponse<T> success(String msg, T data) {
        return new YZResponse<T>(MessageEnum.SUCCESS.getCode(), msg, data);
    }


    /**
     * Create by error server response.
     *
     * @param <T> the type parameter
     * @return the server response
     */
    public static <T> YZResponse<T> error() {
        return new YZResponse<T>(MessageEnum.ERROR.getCode(), MessageEnum.ERROR.getDesc());
    }

    public static <T> YZResponse<T> error(int errorCode, String errorMessage) {
        return new YZResponse<T>(errorCode, errorMessage);
    }


    /**
     * Create by error message server response.
     *
     * @param <T>          the type parameter
     * @param errorMessage the error message
     * @return the server response
     */
    public static <T> YZResponse<T> errorMessage(String errorMessage) {
        return new YZResponse<T>(MessageEnum.ERROR.getCode(), errorMessage);
    }

    /**
     * Create by error code message server response.
     *
     * @param <T>          the type parameter
     * @param errorCode    the error code
     * @param errorMessage the error message
     * @return the server response
     */
    public static <T> YZResponse<T> errorCodeMessage(int errorCode, String errorMessage) {
        return new YZResponse<T>(errorCode, errorMessage);
    }

    /**
     * Create by error server response.
     *
     * @param <T>          the type parameter
     * @param errorMessage the error message
     * @param data         the data
     * @return the server response
     */
    public static <T> YZResponse<T> error(String errorMessage, T data) {
        return new YZResponse<T>(MessageEnum.ERROR.getCode(), errorMessage, data);
    }

    /**
     * 返回系统状态码以及相应说明
     *
     * @param messageEnum messageEnum
     * @return t
     */
    public static <T> YZResponse<T> response(MessageEnum messageEnum) {
        return new YZResponse<T>(messageEnum.getCode(), messageEnum.getDesc());
    }

    @Override
    public String toString() {
        return "YZResponse{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}
