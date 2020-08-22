package com.baidu.utils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: FDM
 * @Date: 2020/5/3 16:04
 * @Version 1.0
 * @des 预测号码
 */
public class ForcastUtils {

    /*
     * List集合排序
     * */
    public static void getSortList(List<String[]> list){
        for (int i=0;i<list.size();i++){
            /**
             * int compare(String[] p1,String[] p2)返回一个基本类型的整形
             * 返回负数  表示 p1小于p2
             * 返回0    表示 p1等于p2
             * 返回正数  表示 p1大于p2
             * */
            list.sort(new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {

                    //根据每期的期号倒序排序
                    if(Integer.parseInt((o1[0]))> Integer.parseInt(o2[0])){
                        return 1;
                    }
                    else if(Integer.parseInt((o1[0]))== Integer.parseInt(o2[0])){
                        return 0;
                    }
                    return -1;
                }
            });
        }

    }

    /**
     * @des 统计号码出现的次数：map
     * */
    public static HashMap<String, HashMap<String,Integer>> getTJMap(List<String[]> list){
        HashMap<String, HashMap<String,Integer>> indexMap = new HashMap<>();
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        HashMap<String, Integer> map3 = new HashMap<>();
        HashMap<String, Integer> map4 = new HashMap<>();
        HashMap<String, Integer> map5 = new HashMap<>();
        HashMap<String, Integer> map6 = new HashMap<>();
        HashMap<String, Integer> map7 = new HashMap<>();

        for(String[] strings: list){
            String[] nums=strings;

            if(map1.containsKey(nums[1])){
                map1.put(nums[1],map1.get(nums[1])+1);
            }else{
                map1.put(nums[1],1);
            }

            if(map2.containsKey(nums[2])){
                map2.put(nums[2],map2.get(nums[2])+1);
            }else{
                map2.put(nums[2],1);
            }

            if(map3.containsKey(nums[3])){
                map3.put(nums[3],map3.get(nums[3])+1);
            }else{
                map3.put(nums[3],1);
            }

            if(map4.containsKey(nums[4])){
                map4.put(nums[4],map4.get(nums[4])+1);
            }else{
                map4.put(nums[4],1);
            }

            if(map5.containsKey(nums[5])){
                map5.put(nums[5],map5.get(nums[5])+1);
            }else{
                map5.put(nums[5],1);
            }

            if(map6.containsKey(nums[6])){
                map6.put(nums[6],map6.get(nums[6])+1);
            }else{
                map6.put(nums[6],1);
            }

            if(map7.containsKey(nums[7])){
                map7.put(nums[7],map7.get(nums[7])+1);
            }else{
                map7.put(nums[7],1);
            }
        }
        indexMap.put("红1",map1);indexMap.put("红2",map2);indexMap.put("红3",map3);indexMap.put("红4",map4);
        indexMap.put("红5",map5);indexMap.put("红6",map6);indexMap.put("蓝7",map7);
        return indexMap;
    }

    /**
     * @des version 1.0
     * @des 预测号码
     * */
    public static List<Integer> forcastNum(HashMap<String,HashMap<String,Integer>> indexmap){

        ArrayList<Integer> forcastList = new ArrayList<>();
        HashMap<String, Integer> red1 = indexmap.get("红1");
        HashMap<String, Integer> red2 = indexmap.get("红2");
        HashMap<String, Integer> red3 = indexmap.get("红3");
        HashMap<String, Integer> red4 = indexmap.get("红4");
        HashMap<String, Integer> red5 = indexmap.get("红5");
        HashMap<String, Integer> red6 = indexmap.get("红6");
        HashMap<String, Integer> blue7 = indexmap.get("蓝7");

        List<String> maxKey1 = sortMapByValue(red1);
        List<String> maxKey2 = sortMapByValue(red2);
        List<String> maxKey3 = sortMapByValue(red3);
        List<String> maxKey4 = sortMapByValue(red4);
        List<String> maxKey5 = sortMapByValue(red5);
        List<String> maxKey6 = sortMapByValue(red6);
        List<String> maxKey7 = sortMapByValue(blue7);

        //预测
        int[] forcast1,forcast2,forcast3,forcast4,forcast5,forcast6,forcast7;
        //红球范围 1-32
        //第一个红球
        if(Integer.parseInt(maxKey1.get(0))==32 || Integer.parseInt(maxKey1.get(0))+3>=32 ){
            forcast1 = randomCommon(Integer.parseInt(maxKey1.get(0)) - 3, Integer.parseInt(maxKey1.get(0)), 1);
        }else if(Integer.parseInt(maxKey1.get(0))==1 || Integer.parseInt(maxKey1.get(0))-3<=0){
            forcast1 = randomCommon(Integer.parseInt(maxKey1.get(0)), Integer.parseInt(maxKey1.get(0)) + 3, 1);
        }else{
            forcast1 = randomCommon(Integer.parseInt(maxKey1.get(0))-3, Integer.parseInt(maxKey1.get(0)) + 3, 1);
        }

        //第二个红球
        if(Integer.parseInt(maxKey2.get(0))==32 || Integer.parseInt(maxKey2.get(0))+3>=32 ){
            forcast2 = randomCommon(Integer.parseInt(maxKey2.get(0)) - 3, Integer.parseInt(maxKey2.get(0)), 1);
        }else if(Integer.parseInt(maxKey2.get(0))==1 || Integer.parseInt(maxKey2.get(0))-3<=0){
            forcast2 = randomCommon(Integer.parseInt(maxKey2.get(0)), Integer.parseInt(maxKey2.get(0)) + 3, 1);
        }else{
            forcast2 = randomCommon(Integer.parseInt(maxKey2.get(0))-3, Integer.parseInt(maxKey2.get(0)) + 3, 1);
        }

        //第三个红球
        if(Integer.parseInt(maxKey3.get(0))==32 || Integer.parseInt(maxKey3.get(0))+3>=32 ){
            forcast3 = randomCommon(Integer.parseInt(maxKey3.get(0)) - 3, Integer.parseInt(maxKey3.get(0)), 1);
        }else if(Integer.parseInt(maxKey3.get(0))==1 || Integer.parseInt(maxKey3.get(0))-3<=0){
            forcast3 = randomCommon(Integer.parseInt(maxKey3.get(0)), Integer.parseInt(maxKey3.get(0)) + 3, 1);
        }else{
            forcast3 = randomCommon(Integer.parseInt(maxKey3.get(0))-3, Integer.parseInt(maxKey3.get(0)) + 3, 1);
        }

        //第四个红球
        if(Integer.parseInt(maxKey4.get(0))==32 || Integer.parseInt(maxKey4.get(0))+3>=32 ){
            forcast4 = randomCommon(Integer.parseInt(maxKey4.get(0)) - 3, Integer.parseInt(maxKey4.get(0)), 1);
        }else if(Integer.parseInt(maxKey4.get(0))==1 || Integer.parseInt(maxKey4.get(0))-3<=0){
            forcast4 = randomCommon(Integer.parseInt(maxKey4.get(0)), Integer.parseInt(maxKey4.get(0)) + 3, 1);
        }else{
            forcast4 = randomCommon(Integer.parseInt(maxKey4.get(0))-3, Integer.parseInt(maxKey4.get(0)) + 3, 1);
        }
        //第五个红球
        if(Integer.parseInt(maxKey5.get(0))==32 || Integer.parseInt(maxKey5.get(0))+3>=32 ){
            forcast5 = randomCommon(Integer.parseInt(maxKey5.get(0)) - 3, Integer.parseInt(maxKey5.get(0)), 1);
        }else if(Integer.parseInt(maxKey5.get(0))==1 || Integer.parseInt(maxKey5.get(0))-3<=0){
            forcast5 = randomCommon(Integer.parseInt(maxKey5.get(0)), Integer.parseInt(maxKey5.get(0)) + 3, 1);
        }else{
            forcast5 = randomCommon(Integer.parseInt(maxKey5.get(0))-3, Integer.parseInt(maxKey5.get(0)) + 3, 1);
        }

        //第六个红球
        if(Integer.parseInt(maxKey6.get(0))==32 || Integer.parseInt(maxKey6.get(0))+3>=32 ){
            forcast6 = randomCommon(Integer.parseInt(maxKey6.get(0)) - 3, Integer.parseInt(maxKey6.get(0)), 1);
        }else if(Integer.parseInt(maxKey6.get(0))==1 || Integer.parseInt(maxKey6.get(0))-3<=0){
            forcast6 = randomCommon(Integer.parseInt(maxKey6.get(0)), Integer.parseInt(maxKey6.get(0)) + 3, 1);
        }else{
            forcast6 = randomCommon(Integer.parseInt(maxKey6.get(0))-3, Integer.parseInt(maxKey6.get(0)) + 3, 1);
        }

        //范围限制  蓝球 1-16
        if(Integer.parseInt(maxKey7.get(0))==16 || Integer.parseInt(maxKey7.get(0))+3>=16 ){
            forcast7 = randomCommon(Integer.parseInt(maxKey7.get(0)) - 3, Integer.parseInt(maxKey7.get(0)), 1);
        }else if(Integer.parseInt(maxKey7.get(0))==1 || Integer.parseInt(maxKey7.get(0))-3<=0){
            forcast7 = randomCommon(Integer.parseInt(maxKey7.get(0)), Integer.parseInt(maxKey7.get(0)) + 3, 1);
        }else{
            forcast7 = randomCommon(Integer.parseInt(maxKey7.get(0))-3, Integer.parseInt(maxKey7.get(0)) + 3, 1);
        }


        //封装数据
        forcastList.add(forcast1[0]);forcastList.add(forcast2[0]);forcastList.add(forcast3[0]);forcastList.add(forcast4[0]);
        forcastList.add(forcast5[0]);forcastList.add(forcast6[0]);forcastList.add(forcast7[0]);

        return forcastList;
    }

    /**
     * 随机指定范围内N个不重复的数，最简单的方法
     * @param min 指定范围最小值
     * @param max 指定范围最大值
     * @param n 随机数个数
     * */
    private static int[] randomCommon(int min, int max, int n){
        if(n>(max-min+1)|| max<min){
            return null;
        }else{
            int[] result =new int[n];
            int count=0;
            while (count<n) {
                int num=(int)(Math.random()*(max-min))+min;
                boolean flag=true;
                for(int j=0;j<n;j++){
                    if(num==result[j]){
                        flag=false;
                        break;
                    }
                }
                if(flag){
                    result[count] =num;
                    count++;
                }
            }
            return result;
        }
    }

    /**
     * map集合根据value大小排序
     * */
    private static List<String> sortMapByValue(Map<String, Integer> map){
        int size = map.size();
        //通过map.entrySet()将map转化为"1.B.!.e=78" 形式的list集合
        List<Map.Entry<String,Integer>> list=new ArrayList<Map.Entry<String, Integer>>(size);
        list.addAll(map.entrySet());

        List<String> keys = list.stream()
                .sorted(Comparator.comparing(Map.Entry<String,Integer>::getValue).reversed())
                .map(Map.Entry<String,Integer>::getKey)
                .collect(Collectors.toList());

        return keys;
    }

    /**
     * 给相邻的号码排序，如果出现相邻值相同，则后一位+1
     * */
    public static List<Integer> sortList(List<Integer> list){
        ArrayList<Integer> newlist = new ArrayList<>();
        for(int i=0;i<list.size()-1;i++){
            newlist.add(list.get(i));
        }
        newlist.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        //最后一位不管
        for(int i=0;i<newlist.size();i++){
            if(i+1!=newlist.size()){
                if(newlist.get(i).equals(newlist.get(i + 1))){
                    if(newlist.get(i)==33){
                        newlist.remove(i);
                        newlist.add(i,newlist.get(i)-1);
                        break;
                    }else{
                        if(i+1==newlist.size()-1){
                            int number=newlist.get(i + 1);
                            newlist.remove(i+1);
                            newlist.add(number+1);
                        }else{
                            newlist.remove(i+1);
                            newlist.add(i+1,newlist.get(i + 1)+1);
                        }
                        break;
                    }
                }
            }
        }
        ArrayList<Integer> list2 = new ArrayList<>(newlist);
        list2.add(list.get(list.size()-1));
        return sortListAgain(list2);
    }

    /**
     * 再一次排序
     * @param list 集合
     * @return list
     * */
    private static List<Integer> sortListAgain(List<Integer> list){
        ArrayList<Integer> newlist = new ArrayList<>();
        for(int i=0;i<list.size()-1;i++){
            newlist.add(list.get(i));
        }
        newlist.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        ArrayList<Integer> list2 = new ArrayList<>(newlist);
        list2.add(list.get(list.size()-1));
        return list2;
    }

}
