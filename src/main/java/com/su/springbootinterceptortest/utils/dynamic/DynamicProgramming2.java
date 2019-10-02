package com.su.springbootinterceptortest.utils.dynamic;

/**
 * 杨辉三角
 * 极客时间
 */
public class DynamicProgramming2 {

    private int[][] a = new int[][]{{5,0,0,0,0},{7,8,0,0,0},{2,3,4,0,0},{4,9,6,1,0},{2,7,9,4,5}};
    int n = 5;
    private int[][] mem = new int[n][n];

    private int[] b = new int[]{9,2,4,8,7,3};
    int m = b.length;

    /**
     * 状态转移表法
     * @return
     */
    public void maxPathStatus() {
        int[][] status = new int[n][n];
        status[0][0] = a[0][0];

        for(int i = 1; i < n; i++) {
            status[i][0] = status[i-1][0] + a[i][0];
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j < n; j++) {
                status[i][j] = Math.min(status[i-1][j-1], status[i][j-1]) + a[i][j];
            }
        }

        //打印所有路径
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(status[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 状态转移方程
     */
    public int mathPathEquation(int i, int j) {

        if(i == 0 && j == 0) {
            return a[0][0];
        }

        int left = Integer.MAX_VALUE;
        if(i - 1 >= 0 && j - 1 >= 0) {
            left = mathPathEquation(i - 1, j - 1);
        }

        int up = Integer.MAX_VALUE;
        if(i - 1 >= 0) {
            up = mathPathEquation(i-1, j);
        }

        int currentValue = a[i][j] + Math.min(left, up);
        return currentValue;
    }

    /**
     * 最长递增子序列长度，例如2，9，3，6，5，1，4  最长递增子序列是2，3，5，7，结果是4
     * 用状态转移法，对于第i个数，最长子序列是第0--i个数中所有最长子序列中最大的值加1。以下是代码：
     * @param
     */

    public void getSbuSerialStatus() {
        int[] status = new int[m];
        status[0] = 1;
        for(int i = 1; i < m; i++) {
            for(int j = i - 1; j >=0; j--) {
                if(b[i] > b[j] && status[j] > status[i]) {
                    status[i] = status[j] + 1;
                }
            }
            if(status[i] == 0)
                status[i] = 1;
        }

        for(int i = 0; i < m; i++) {
            System.out.print(status[i] + " ");

        }
    }



    public static void main(String args[]) {
        DynamicProgramming2 dynamicProgramming2 = new DynamicProgramming2();
        /*dynamicProgramming2.maxPathStatus();

        System.out.println("\n");
        System.out.println(dynamicProgramming2.mathPathEquation(4, 4));*/

        dynamicProgramming2.getSbuSerialStatus();

    }
}
