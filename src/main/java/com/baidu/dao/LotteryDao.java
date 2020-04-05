package com.baidu.dao;

import com.baidu.entity.Lottery;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: FDM
 * @Date: 2020/4/4 15:18
 * @Version 1.0
 */
@Repository
@Mapper
public interface LotteryDao {

    List<Lottery> findAll();

    //插入
    void save(Lottery lottery);
}
