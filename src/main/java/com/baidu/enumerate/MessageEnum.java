package com.baidu.enumerate;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;

/**
 *
 * 响应码枚举类
 */
@Getter
@AllArgsConstructor
public enum MessageEnum {

    /**
     * Success response code.
     *
     * 请求操作成功
     */
    SUCCESS(200, "操作成功!"),
    /**
     * Error response code.
     *
     * 请求操作失败
     */
    ERROR(501, "操作失败!"),
    /**
     * Illegal argument response code.
     *
     * 参数错误
     */
    ILLEGAL_ARGUMENT(502, "请求参数错误!"),
    /**
     * Need login response code.
     *
     * 需要登录
     */
    NEED_LOGIN(50000, "登录超时,请重新登录!"),
    /**
     * Exception response code.
     *
     * 服务器内部错误
     */
    EXCEPTION(500, "该请求发生异常,请稍后重试!"),
    /**
     * Sys not found error response code.
     */
    SYS_NOT_FOUND_ERROR(404, "未找到相应资源!"),

    DATABASE_ERROR(6000,"数据库异常,请稍后重试!"),
    /**
     * Sys not use error response code.
     */
    SYS_NOT_USE_ERROR(403, "资源不可用!");

    private final int code;

    private final String desc;

    /**
     * 根据code获取枚举
     * @param code code
     * @return 枚举
     */
    public static MessageEnum getEnumByCode(int code){
        return Arrays.stream(values())
                .filter(x-> Objects.equals(x,code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("没有找到对应的枚举类型"));
    }

    /**
     * 根据code获取枚举值
     * @param code code
     * @return str
     */
    public static String getDescByCode(int code){
        return Arrays.stream(values())
                .filter(x->Objects.equals(x,code))
                .map(MessageEnum::getDesc)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("没有找到对应的枚举值"));
    }
}
