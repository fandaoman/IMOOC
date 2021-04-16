package com.baidu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @Auther fandaoman
 * @date 2019/10/26 22:25
 * @Ver 1.0
 * */
@MapperScan("com.baidu.dao")
@SpringBootApplication
public class YZApplication {

    public static void main(String[] args) {
        SpringApplication.run(YZApplication.class,args);
    }
}
