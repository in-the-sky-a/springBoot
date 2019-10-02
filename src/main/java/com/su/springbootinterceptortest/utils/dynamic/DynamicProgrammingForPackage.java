package com.su.springbootinterceptortest.utils.dynamic;

/**
 * 动态规划背包问题
 *     weight: 物品重量，n: 物品个数，w: 背包可承载重量
 */
public class DynamicProgrammingForPackage {

    private static int[][] matrix = {{1,3,5,9},{2,1,3,4},{5,2,6,7},{6,8,4,3}};
    private static int n = 4;
    private static int[][] mem = new int[4][4];

    /**
     * 状态转移表法
     * @param weight
     * @param n
     * @param w
     * @return
     */
    public int knapsack(int[] weight, int n, int w) {
        boolean[][] states = new boolean[n][w+1]; // 默认值 false
        states[0][0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (weight[0] <= w) {
            states[0][weight[0]] = true;
        }
        for (int i = 1; i < n; ++i) { // 动态规划状态转移
            for (int j = 0; j <= w; ++j) {// 不把第 i 个物品放入背包
                if (states[i-1][j] == true) states[i][j] = states[i-1][j];
            }
            for (int j = 0; j <= w-weight[i]; ++j) {// 把第 i 个物品放入背包
                if (states[i-1][j]==true) states[i][j+weight[i]] = true;
            }
        }

        int k = w;

        for (; k >= 0; --k) { // 输出结果
            if (states[n-1][k] == true)
                break;
        }

        for(int i = n-1; i >= 0; i--) {
            if(k - weight[i] >= 0 && states[i-1][k-weight[i]] == true) {
                System.out.println(weight[i]);
                k = k - weight[i];
            }
        }

        return 0;
    }


    /**
     * 状态转移方程法
     * @param
     */
    public int minDist(int i, int j) {

        if(i == 0 && j == 0) {
            mem[0][0] = matrix[0][0];
            return matrix[0][0];
        }

        if(mem[i][j] > 0)
            return mem[i][j];

        int left = Integer.MAX_VALUE;
        if(i-1 >= 0) {
            left = minDist(i-1, j);
        }


        int up = Integer.MAX_VALUE;
        if(j - 1 >= 0) {
            up = minDist(i, j - 1);
        }


        int currentMax = matrix[i][j] + Math.min(left, up);

        mem[i][j] = currentMax;
        return currentMax;

    }



    public static void main(String args[]) {
        DynamicProgrammingForPackage dynamicProgrammingForPackage = new DynamicProgrammingForPackage();


        /*int n = 5;
        int w = 9;
        int[] weight = new int[]{2,2,4,6,3};
        dynamicProgrammingForPackage.knapsack(weight, n, w);*/


        dynamicProgrammingForPackage.minDist(3,3);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(mem[i][j] + " ");
            }
            System.out.println();
        }

    }

}
