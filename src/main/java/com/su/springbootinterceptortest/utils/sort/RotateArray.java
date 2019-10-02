package com.su.springbootinterceptortest.utils.sort;


/**
 * 旋转数组，找最小值
 * 例如：12345 --》 45123
 * 最小值是1
 * 剑指offer面试题11
 */
public class RotateArray {

    public static void main(String args[]) {

        //int[] v = {4,5,1,2,3};
        int[] v = {1,1,0,1,1,1};
        //int[] v = {1,1,1,0,1,1};


        int min = findMin(v, 0, v.length - 1);
        System.out.println(v[min]);
    }
    private static int findMin(int v[], int start, int end) {

        int p1 = start;
        int p2 = end;
        int min = start;

        while(p2 > p1) {

            if(p2 == (p1 + 1)) {
                min = p2;
                break;
            }

            int middle = (p1 + p2) / 2;

            if(v[p1] == v[middle] && v[middle] == v[p2]) {
                return findByOrder(v, p1, p2);
            }


            if(v[middle] >= v[p1]) {
                p1 = middle;
            } else {
                p2 = middle;
            }

        }

        return min;
    }

    private static int findByOrder(int[] v, int p1, int p2) {

        int i = p1;

        for(; i < p2; i++) {
            if(v[i] > v[i + 1])
                break;
        }

        return i + 1;
    }

}
