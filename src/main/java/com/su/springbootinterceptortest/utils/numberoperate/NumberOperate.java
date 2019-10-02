package com.su.springbootinterceptortest.utils.numberoperate;

public class NumberOperate {

    public static void main(String args[]) {

/*
        System.out.println(powerOperate(2, 6));
*/

        int[] a = new int[]{0,9,9};
        /*addOperate(a);
        printArray(a);*/

        printNBits(3);

    }

    /**
     * 剑指offer16
     *求一个数的指数，这里比较简单，指数为正值，且底数大于0,且不考虑大数
     */
    private static long powerOperate(long base, long exp) {
        
        if(exp == 0)
            return 0;
        if(exp == 1)
            return base;

        long  result = powerOperate(base, exp >> 1);
        result *= result;

        if((exp & 1) == 1)
            result *= base;

        return result;

    }


    /**
     *剑指offer 17
     * 打印1-最大n位数
     */
    private static void printNBits(int n) {
        int[] a = new int[n + 1];
       // while(!breakCondition(a)) {
        while(true) {
            addOperate(a);
            if(a[0] == 1)  //结束条件
                break;
            printArray(a);
        }
    }

    private static boolean breakCondition(int[] a) {
        for(int i = 0; i < a.length; i++)
            if(a[i] != 9)
                return false;

            return true;
    }


    /**
     * n位数+1
     */
    private static int[] addOperate(int[] a) {

        int pre = 0; //进位

        for(int i = a.length - 1; i >= 0; i--) {

            int add = 0;
            if(i == a.length - 1)
                add = 1;

            if(a[i] + add + pre < 10) {
                a[i] = a[i] + add + pre;
                pre = 0;
            } else {
                a[i] = (a[i] + pre + add) % 10;
                pre = 1;

            }

            if(pre == 0)
                break;
        }
        return a;
    }

    private static void printArray(int[] a) {
        int start = 0;
        for(; start < a.length; start++) {
            if(a[start] != 0)
                break;
        }

        for(; start < a.length; start++) {
            System.out.print(a[start]);
        }

        System.out.println();
    }

}