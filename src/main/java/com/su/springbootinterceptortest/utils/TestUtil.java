package com.su.springbootinterceptortest.utils;

import com.su.springbootinterceptortest.utils.linklist.Bean;
import org.omg.CORBA.IntHolder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestUtil {

    public static void main(String args[]) {
        //fun_A();

        BigDecimal multiply = BigDecimal.valueOf(10).add(BigDecimal.valueOf(10).multiply(BigDecimal.valueOf(2)));
       // System.out.println(multiply);

       /* String test = "123";
        print(test);
        System.out.println(test);*/

        /*changeIntValueTest();*/

        /*changableParamTest();*/

        enumTest();
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



    private static void print(String s) {
        s = s + "456";
    }


    private void toArray() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(3);
        //必须是封装类型
        /*int[] a = new int[list.size()];
        list.toArray(a);*/

        list.toArray(new Integer[list.size()]);

        Integer a = Integer.valueOf(3);
    }


    /**
     * int传值改变
     */
    private static void changeIntValueTest() {
        IntHolder intHolder = new IntHolder();
        intHolder.value = 3;
        changeIntValue(intHolder);
        System.out.println(intHolder.value);
    }

    private static void changeIntValue(IntHolder intHolder) {
        intHolder.value = intHolder.value * 2;
    }

    /**
     * 可变参数
     */
    private static void changableParamTest() {
        changableParam("123","234","445");
    }

    private static void changableParam(String... args) {
        for(String string: args) {
            System.out.println(string);
        }
    }

    /**
     * 枚举
     */
    public enum SizeEnum{
        SMALL("s"),
        MIDDLE("m"),
        LARGE("l");

        private String sizeNum;
        SizeEnum(String sizeNum) {
            this.sizeNum = sizeNum;
        }

        public String getSizeNum() {
            return sizeNum;
        }
    }

    private static void enumTest() {
        SizeEnum size = SizeEnum.LARGE;
        for(SizeEnum sizeEnum: SizeEnum.values()) {
            System.out.println(sizeEnum.sizeNum);
        }

        Enum.valueOf(SizeEnum.class, "SMALL");
    }



}
