package com.baidu.controller;

import com.baidu.entity.Lottery;
import com.baidu.service.LotteryService;
import com.baidu.utils.JSONUtil;
import com.baidu.utils.ReadExcelUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

import static com.baidu.utils.ForcastUtils.*;

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
        String lotteryJson = JSONUtil.getLotteryJson(lotteries);
        return lotteryJson.substring(1,lotteryJson.length()-1);
    }

    /*
    * 单条数据插入
    * */
    @RequestMapping("/insertone")
    @ResponseBody
    public String insertOne(@Param("param") String param){
        if("".equals(param)){
            return "插入失败";
        }else{
            System.out.println("------"+param);
        }
        return null;
    }

    /**
     * @param file 批量插入
     */
    @RequestMapping("/insertExcel")
    public void insertExcel(MultipartFile file) throws Exception {
        //调用utils方法
        if(file!=null){
            List<Lottery> lotteries = ReadExcelUtils.loadExcel(file.getInputStream());
            for(Lottery lottery:lotteries){
                lotteryService.save(lottery);
            }
        }
    }

    /**
     * 预测号码
     *
     * @param num 根据选择的期数做预测
     */
    @RequestMapping("/forcast")
    @ResponseBody
    public List<Integer> getForcase(@Param("num") String num){
        List<Lottery> lotteries;
        if("".equals(num)){
            lotteries = lotteryService.findAll();
        }else{
            lotteries = lotteryService.findByNum(Integer.parseInt(num));
        }

        ArrayList<String[]> list = new ArrayList<>();
        for(Lottery lottery:lotteries){
            String[] str=new String[8];
            str[0]=lottery.getId();
            str[1]=lottery.getRedNumberOne();str[2]=lottery.getRedNumberTwo();
            str[3]=lottery.getRedNumberThree();str[4]=lottery.getRedNumberThour();
            str[5]=lottery.getRedNumberFive();str[6]=lottery.getRedNumberSix();
            str[7]=lottery.getBlueOne();
            list.add(str);
        }
        /*集合排序*/
        getSortList(list);

        /*统计这几期数据每个位置号码出现的次数*/
        HashMap<String, HashMap<String, Integer>> indexmap = getTJMap(list);

        /*根据期号排序完------成预测数据*/
        List<Integer> forcastNum1 = forcastNum(indexmap);
        System.out.println("第一次预测数号码："+sortList(forcastNum1));

        //预测100次。再从这100次中预测出一条数据
        ArrayList<String[]> lastForcast = new ArrayList<>();
        for(int i=0;i<100;i++){
            String[] aa = new String[8];
            List<Integer> forcastNum2 = forcastNum(indexmap);
            aa[0]="20032";aa[1]=forcastNum2.get(0).toString();aa[1]=forcastNum2.get(0).toString();
            aa[2]=forcastNum2.get(1).toString();aa[3]=forcastNum2.get(2).toString();
            aa[4]=forcastNum2.get(3).toString();aa[5]=forcastNum2.get(4).toString();
            aa[6]=forcastNum2.get(5).toString();aa[7]=forcastNum2.get(6).toString();
            lastForcast.add(aa);
        }

        //再一次预测中预测的数据
        getSortList(lastForcast);
        HashMap<String, HashMap<String, Integer>> indexMap1 = getTJMap(lastForcast);
        List<Integer> forcastNum2 = forcastNum(indexMap1);

        System.out.println("第二次预测的号码为："+sortList(forcastNum2));
        return forcastNum1;
    }



    public static void main(String[] args) {

        String[] a1={"20031","02","05","09","15","16","27","09"};
        String[] a2={"20030","17","18","21","29","30","32","03"};
        String[] a3={"20029","01","12","18","20","30","32","05"};
        String[] a4={"20028","05","06","15","18","26","32","08"};
        String[] a5={"20027","12","13","14","24","25","28","06"};
        ArrayList<String[]> list = new ArrayList<>();
        list.add(a1);list.add(a2);list.add(a3);list.add(a4);list.add(a5);

        /*集合排序*/
        getSortList(list);

        /*统计这几期数据每个位置号码出现的次数*/
        HashMap<String, HashMap<String, Integer>> indexmap = getTJMap(list);

        /*根据期号排序完------成预测数据*/
        List<Integer> forcastNum1 = forcastNum(indexmap);
        System.out.println("第一次预测数号码："+sortList(forcastNum1));

        //预测100次。再从这100次中预测出一条数据
        ArrayList<String[]> lastForcast = new ArrayList<>();
        for(int i=0;i<100;i++){
            String[] aa = new String[8];
            List<Integer> forcastNum2 = forcastNum(indexmap);
            aa[0]="20032";aa[1]=forcastNum2.get(0).toString();aa[1]=forcastNum2.get(0).toString();
            aa[2]=forcastNum2.get(1).toString();aa[3]=forcastNum2.get(2).toString();
            aa[4]=forcastNum2.get(3).toString();aa[5]=forcastNum2.get(4).toString();
            aa[6]=forcastNum2.get(5).toString();aa[7]=forcastNum2.get(6).toString();
            lastForcast.add(aa);
        }

        //再一次预测中预测的数据
        getSortList(lastForcast);
        HashMap<String, HashMap<String, Integer>> indexMap1 = getTJMap(lastForcast);
        List<Integer> forcastNum2 = forcastNum(indexMap1);

        System.out.println("第二次预测的号码为："+sortList(forcastNum2));

    }







}
