package com.su.springbootinterceptortest.utils.sort;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 重点： 二分查找、归并、快排
 */
public class Sort {

    public static void main(String args[]) {
        int[] v = {6,8,3,9,2,7,1,5,3,22,10};
        Sort sort = new Sort();
        //sort.bubbleSort(v);
        //sort.selectSort(v);
        //sort.insertSort(v);
        /*sort.shellSort(v);
        System.out.println();*/
        /*sort.mergeSort(v, 0, v.length - 1);
        sort.print(v);*/

        sort.quickSort2(v, 0, v.length - 1);
        sort.print(v);
    }



    private void bubbleSort(int[] v) {
        int n = v.length;
        for(int i = 0; i < n; i++) {//表示排序多少次
            for(int j = 0; j < n -1 - i; j++) {
                if(v[j] > v[j+1]) {
                    int temp = v[j];
                    v[j] = v[j+1];
                    v[j+1] = temp;
                }
            }
        }

        print(v);

    }


    /**
     * 改进算法，对已排好序的数据组不用重复比较
     * @param v
     */
    private void bubbleSortImprove(int[] v) {
        int n = v.length;
        for(int i = 0; i < n; i++) {//表示排序多少次

            boolean flag = false;
            for(int j = 0; j < n -1 - i; j++) {
                if(v[j] > v[j+1]) {
                    int temp = v[j];
                    v[j] = v[j+1];
                    v[j+1] = temp;
                    flag = true;
                }
            }

            if(!flag)
                break;
        }

        print(v);

    }


    private void selectSort(int[] v) {
        int n = v.length;
        for(int i = 0; i < n - 1; i++) {

            int max = v[i];
            int tempIndex = i;
            for(int j = i + 1; j < n; j++) {

                if(v[j] > max) {
                    max = v[j];
                    tempIndex = j;
                }
            }

            if(tempIndex != i) {
                v[tempIndex] = v[i];
                v[i] = max;
            }
        }

        print(v);


    }



    private void insertSort(int[] v) {
        int n = v.length;
        for(int i = 0; i < n - 1; i++) {
            int value = v[i];
            int j = i - 1;
            for(; j > 0; j--) {
                if(v[j] < value) {
                    v[j+1] = v[j];
                } else
                    break;
            }
            v[j+1] = value;
        }

        print(v);
    }




    private void shellSort(int[] v) {

        int increment = v.length;

        do {
            increment = increment / 2;

            for(int k = 0; k < increment; k++) {

                for(int i = k + increment; i < v.length; i+=increment) {
                    for(int j = i; j > k; j-=increment) {
                        if(v[j] < v[j-increment]) {
                            int temp = v[j];
                            v[j] = v[j-increment];
                            v[j-increment] = temp;
                        }
                    }
                }

            }


        } while (increment > 1);

        print(v);
    }


    //第一个作为哨兵节点
    private void quickSort(int[] v, int start, int end) {

        if(end < start)
            return;

        int i = start, j = end, k = v[i];
        while(i < j) {

            //从后往前找小于k的数  没有等号就会陷入死循环
            while(i < j && v[j] >= k) {
                j--;
            }
            //找到j
            v[i] = v[j];

            //从前往后找大于k的数
            while(i < j && v[i] <= k) {
                i++;
            }

            v[j] = v[i];

        }

        v[j] = k;

        quickSort(v, start, j - 1);
        quickSort(v, j + 1, end);


    }


    //找一个随机数作为哨兵节点
    private void quickSort2(int[] v, int start, int end) {
        int p = partition(v, start, end);
        quickSort(v, start, p-1);
        quickSort(v, p+1, end);

    }

    private int partition(int[] v, int start, int end) {

        int random = ThreadLocalRandom.current().nextInt(start, end);
        swap(v[random], v[end]);

        int p = v[end];
        int i = start;
        int j = start;
        for(; j < end; j++) {
            if(v[j] < p) {
                swap(v[i], v[j]);
                i++;

            }
        }

        swap(v[i], v[end]);
        return i;
    }

    private void swap(int a, int b) {
        int temp = a;
        a=b;
        b = temp;
    }


    private void mergeSort(int[] v, int start, int end) {
        if(end > start) {
            int middle = (end + start) / 2;
            mergeSort(v, start, middle);
            mergeSort(v, middle + 1, end);
            merge(v, start, middle, end);

        }

    }

    private void merge(int[] v, int start, int middle, int end) {

        int[] temp = new int[end - start + 1];
        int i = start;
        int j = middle + 1;
        int k = 0;
        while(i <= middle && j <= end) {

            if(v[i] <= v[j]) {
                temp[k++] = v[i];
                i++;
            }

            if(v[j] < v[i]) {
                temp[k++] = v[j];
                j++;
            }
        }


        while(i <= middle) {
            temp[k++] = v[i++];
        }

        while(j <= end) {
            temp[k++] = v[j++];
        }

        for(int m = 0; m < temp.length; m++) {
            v[m + start] = temp[m];
        }

    }


    private void print(int[] v) {
        for(int a: v) {
            System.out.print("\t" + a);
        }
    }
}
