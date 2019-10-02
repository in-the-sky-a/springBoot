package com.su.springbootinterceptortest.utils.dynamic;


/**
 * 剑指offer 面试题14
 * 剪绳子求最大乘积
 * 长m，n段，乘积最大
 */
public class DynamicProgramming {

    public static void main(String args[]) {
        int max = usualMethod(8);
        System.out.println(max);
    }


    /**
     * 常规做法：一个一个尝试，时间复杂度 O(n2)
     */
    private static int usualMethod(int length) {

        int max = 1;
        if(length == 1)
            return 0;
        if(length == 2)
            return 1;
        if(length == 3) {
            return 2;
        }

        int[] p = new int[length + 1];
        p[0] = 0;
        p[1] = 1;
        p[2] = 2;
        p[3] = 3;

        for(int i = 4; i <= length; i++) {
            for(int j = 1; j <= i / 2; j++) {
                if(p[j] * p[i-j] > max) {
                    max = p[j] * p[i-j];

                }
                p[i] = max;
            }
        }

        return p[length];

    }
}
