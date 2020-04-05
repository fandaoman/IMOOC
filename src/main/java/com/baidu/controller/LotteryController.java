package com.baidu.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baidu.entity.Lottery;
import com.baidu.service.LotteryService;
import com.baidu.utils.ReadExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.InputStream;
import java.util.List;

/**
 * @Author: FDM
 * @Date: 2020/4/4 15:26
 * @Version 1.0
 */
@RestController
@RequestMapping("/lottery")
public class LotteryController {
    //注入lotteryService

    @Autowired
    private LotteryService lotteryService;


    @RequestMapping("/findAll")
    @ResponseBody
    public String  findAll(){
        List<Lottery> lotteries = lotteryService.findAll();
        String lotteryJson = getLotteryJson(lotteries);
        String news =lotteryJson.substring(1,lotteryJson.length()-1);
        return news;
    }

    /**
     * @Introduce 批量插入
    * */
    @RequestMapping("/insertExcel")
    public void InsertExcel(MultipartFile file) throws Exception {
        //调用utils方法
        if(file==null){
        }else{
            List<Lottery> lotteries = ReadExcelUtils.loadExcel(file.getInputStream());
            for(Lottery lottery:lotteries){
                lotteryService.save(lottery);
            }
        }
    }

    public String getLotteryJson(List<Lottery> lists)
    {
        if(null == lists){
            return null;
        }
        JSONArray jsonArray = new JSONArray();
        for(Lottery lottery : lists){
            JSONObject jo = new JSONObject();
            jo.put("id", lottery.getId());
            jo.put("redNumberOne", lottery.getRedNumberOne());
            jo.put("redNumberTwo", lottery.getRedNumberTwo());
            jo.put("redNumberThree", lottery.getRedNumberThree());
            jo.put("redNumberThour", lottery.getRedNumberThour());
            jo.put("redNumberFive", lottery.getRedNumberFive());
            jo.put("redNumberSix", lottery.getRedNumberSix());
            jo.put("blueOne", lottery.getBlueOne());
            jsonArray.add(jo);
        }
        JSONObject jo1 = new JSONObject();
        JSONArray jsonArray1 = new JSONArray();
        jo1.put("total",lists.size());
        jo1.put("rows",jsonArray);
        jsonArray1.add(jo1);
        return jsonArray1.toString();
    }


}
