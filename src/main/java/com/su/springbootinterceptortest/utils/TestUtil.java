package com.su.springbootinterceptortest.utils;

import com.su.springbootinterceptortest.utils.linklist.Bean;

public class TestUtil {

    public static void main(String args[]) {
        fun_A();
    }

    static void fun_A() {

        Bean bean = new Bean();
        bean.setA(1);
        fun_B(bean);
        System.out.println(bean.getA());
    }

    static void fun_B(Bean a) {
        a.setA(2);

    }
}
