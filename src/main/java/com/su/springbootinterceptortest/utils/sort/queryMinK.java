package com.su.springbootinterceptortest.utils.sort;


//查找第k大数
public class queryMinK {

    public static void main(String args[]) {
        int[] v = {6,8,3,9,2,7,1,5,3,22,10};
        //	1	2	3	3	5	6	7	8	9	22	10
        query(v, 0, v.length - 1, 5);
    }

    private static void query(int[] v, int start, int end, int k) {
        if(k < start || k > end)
            return;
        int partition = partition(v, start, end);
        if(partition == k) {
            System.out.println("找到第 "+k+"个数：" + v[partition]);
            return;
        } else if(partition > k) {
            query(v, start, partition - 1, k);
        } else {
            query(v, partition + 1, end, k);
        }
    }


    private static int partition(int[] v, int start, int end) {

        int i = start;
        int j = start;
        int p = v[end];
        for(; j < end; j++) {
            if(v[j] < p) {
                int temp = v[i];
                v[i]=v[j];
                v[j] = temp;
                i++;

            }
        }

        int temp = v[i];
        v[i]=v[end];
        v[end] = temp;

        return i;
    }

    private static void swap(int[] v, int i, int j) {
        int temp = v[i];
        v[i]=v[j];
        v[j] = temp;
    }
}
