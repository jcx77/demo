package com.ureport2.demo;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class MainTest {
    /**
     * @Description: TODO(/ dada)
     * @Param: [args]
     * @return: void
     * @Author: zcx
     * @Date: 2020/12/3 19:29
     */
    public static void main(String[] args) {
        String a[] = {"1", "2", "3", "4"};
        String b[] = {"6", "8", "3", "4"};
        List<String> astr = Arrays.asList(a);
        List<String> btrings = Arrays.asList(b);
        String c[] = new String[10];


        int i = 0;
        for (String atring : astr) {
            if (btrings.contains(atring)) {
                c[i] = atring;


                i++;
            }
        }

        System.out.println(Arrays.toString(c));
//        long startTime =  System.currentTimeMillis();   //获取开始时间
////方法~~
//
//        for (Map<String, Object> stringObjectMap : list) {
//            stringObjectMap.get("mc");
//        }
//        long endTime =  System.currentTimeMillis(); //获取结束时间
//        System.out.println("1程序运行时间： "+(endTime-startTime)+"ms");
//        long startTime1 =  System.currentTimeMillis();   //获取开始时间
////方法~~
//        for (String key : map1.keySet()) {
//            map1.get(key);
//        }
//
//        long endTime1 =  System.currentTimeMillis(); //获取结束时间
//        System.out.println("程序运行时间： "+(endTime1-startTime1)+"ms");
    }
}
