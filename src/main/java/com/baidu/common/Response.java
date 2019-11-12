package com.baidu.common;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

/*
 * @Auther fandaoman
 * @date 2019/11/4 16:50
 * @Ver 1.0
 * */
public class Response implements Serializable {

    private static final String OK = "ok";
    private static final String ERROR = "error";
    //请求本身相关内容
    private Meta meta;
    //请求返回的实际信息
    private Object data;

    public Response success() {
        this.meta = new Meta(true, OK);
        return this;
    }

    public Response success(Object data) {
        this.meta = new Meta(true, OK);
        this.data = JSON.toJSON(data);
        return this;
    }

    public Response failure() {
        this.meta = new Meta(false, ERROR);
        return this;
    }

    public Response failure(String message) {
        this.meta = new Meta(false, message);
        return this;
    }

    public Meta getMeta() {
        return meta;
    }

    public Object getData() {
        return data;
    }

    public class Meta {

        private boolean success;
        private String message;

        public Meta(boolean success) {
            this.success = success;
        }

        public Meta(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getMessage() {
            return message;
        }
    }
}
