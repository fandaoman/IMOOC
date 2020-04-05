package com.baidu.service.impl;

import com.baidu.dao.LotteryDao;
import com.baidu.entity.Lottery;
import com.baidu.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: FDM
 * @Date: 2020/4/4 15:24
 * @Version 1.0
 */
@Service
public class LotteryServiceImpl implements LotteryService {
    @Autowired
    private LotteryDao lotteryDao;

    /*查询所有数据*/
    @Override
    public List<Lottery> findAll() {
        return lotteryDao.findAll();
    }

    @Override
    @Transactional
    public void save(Lottery lottery) {
        lotteryDao.save(lottery);
    }
}
