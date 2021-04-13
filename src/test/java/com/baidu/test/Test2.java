package com.baidu.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: FDM
 * @Date: 2020/12/29 22:06
 * @Version 1.0
 */
public class Test2 {

    @Test
    public void test1(){
        int[] arr = {6,3,2,1,7};
        for(int i = 0;i<arr.length-1;i++){//外层循环n-1
            for(int j = 0;j<arr.length-i-1;j++){//内层循环n-i-1
                if(arr[j]>arr[j+1]){//从第一个开始，往后两两比较大小，如果前面的比后面的大，交换位置
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void test2(){
        int i = 0;
        Integer iw = null;
        System.out.println("iw = " + iw);
        System.out.println("i = " + i);
    }
}
