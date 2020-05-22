package com.baidu.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baidu.entity.Lottery;

import java.util.List;

/**
 * @Author: FDM
 * @Date: 2020/5/3 21:42
 * @Version 1.0
 */
public class JSONUtil {

    public static String getLotteryJson(List<Lottery> lists){
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
