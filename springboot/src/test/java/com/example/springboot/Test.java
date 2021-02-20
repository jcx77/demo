package com.example.springboot;

import java.util.Arrays;

public class Test {


    public static void main(String[] args) {
        int[] ins = {7, 8, 3, 6, 2, 0, 87, 23, 4};
        quickSort(ins);
    }

    /**
     * @Description: TODO()
     * @Param: []
     * @return: void
     * @Author: zcx
     * @Date: 2021/1/31 17:24
     */
    public static void quickSort(int[] ins) {
        int start = 0;
        int end = ins.length-1;
        for (int i = 0; i < ins.length; i++) {
            for (int j = 1; j< end; j++) {
                if (ins[start] > ins[j]) {
                    int temp=ins[j];
                    ins[j] = ins[start];
                    ins[start] = temp;
                }
            }
            start++;
        }

        //ins[start]>ins[end];
//        for (int i = 0; i < ins.length; i++) {
//
//            if (i != end-1 && ins[i] > ins[i + 1]) {
//                int temp=ins[i];
//                ins[i] = ins[i + 1];
//                ins[i + 1] = temp;
//            }
//            System.out.print(ins[i]);
//            System.out.print(",");
//        }
        System.out.println(Arrays.toString(ins));
//        System.out.print(ins[i]);
//            System.out.print(",");
    }

}
