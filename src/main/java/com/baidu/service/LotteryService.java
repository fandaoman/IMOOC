package com.baidu.service;


import com.baidu.entity.Lottery;

import java.util.List;

/**
 * @Author: FDM
 * @Date: 2020/4/4 15:23
 * @Version 1.0
 */
public interface LotteryService {
    List<Lottery> findAll();

    void save(Lottery lottery);

    //根据所选的num查询num条记录
    List<Lottery> findByNum(int num);
}
