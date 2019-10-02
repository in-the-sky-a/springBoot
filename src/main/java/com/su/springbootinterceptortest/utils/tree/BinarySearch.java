package com.su.springbootinterceptortest.utils.tree;

public class BinarySearch {

    private int[] value = {1,2,4,5,7,9,11,14,16,27,37,39,45,67,78,88};

   // private int[] value = {1,2,3,4,5,6,7};


    public static void main(String args[]) {
        BinarySearch binarySearch = new BinarySearch();
        binarySearch.binarySearch(16, 0, 15);
    }

    //返回元素e的下标
    private void binarySearch(int e, int start, int end) {

       /* if(value[start] == e) {
            System.out.println(start);
            return;
        }

        if(value[end] == e) {
            System.out.println(end);
            return;
        }

        int n = (end + start) / 2;

        if(value[n] > e) {
            binarySearch(e, start, n - 1);
        } else {
            binarySearch(e, n+1, end);
        }*/

       int n = (end + start) / 2;
       if(end >= start) { // 这个地方很重要，否则会栈溢出
           if(value[n] == e) {
               System.out.println(n);
               return;
           }

           if(value[n] > e) {
               binarySearch(e, start, n - 1);
           } else {
               binarySearch(e, n+1, end);
           }
       }


    }
}
