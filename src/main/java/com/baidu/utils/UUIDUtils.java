package com.baidu.utils;

import org.springframework.stereotype.Component;

import java.util.UUID;

/*
 * @Auther fandaoman
 * @date 2019/10/28 10:45
 * @Ver 1.0生成工具类
 * @UUID
 * */
@Component
public class UUIDUtils {

    public static String getUUID(){
        String uuid = UUID.randomUUID().toString().replace("-","");
        return uuid;
    }
}
