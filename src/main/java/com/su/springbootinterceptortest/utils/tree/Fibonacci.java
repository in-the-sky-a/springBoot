package com.su.springbootinterceptortest.utils.tree;

public class Fibonacci {

    public static void main(String args[]) {
        Fibonacci fibonacci = new Fibonacci();
        System.out.println(fibonacci.fibonacci(50));

        System.out.println(fibonacci.fibonacci2(50));
    }

    //递归
    private long fibonacci(int n) {

        if(n==0)
            return 0;
        if(n == 1)
            return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }



    private long fibonacci2(int n) {
        if(n==0)
            return 0;
        if(n == 1)
            return 1;

        long one = 0;
        long two = 1;

        long result = 0;
        for(int i = 2; i <= n; i++) {
            result = one + two;
            one = two;
            two = result;

        }
        return result;
    }
}
