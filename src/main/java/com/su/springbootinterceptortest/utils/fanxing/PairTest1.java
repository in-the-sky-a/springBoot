package com.su.springbootinterceptortest.utils.fanxing;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class PairTest1 {


    public static void main(String args[]) {
        String[] a = new String[]{"123", "234", "345"};
        Pair<String> minmax = minmax(a);

        System.out.println(minmax.getFirst());
        System.out.println(minmax.getSecond());

        String middle = getMiddle(a);

        //报错
        //Double middle1 = getMiddle(1.23, 1729, 0);
        Collection<Pair<String>> table = new HashSet<Pair<String>>();
        Pair<String> pair1 = new Pair<>();
        Pair<String> pair2 = new Pair<>();
        addAll(table, pair1, pair2);

        Pair.makePair(String::new);
    }

    public static <T extends Comparable> Pair<T> minmax(T[] a) {
        if(a == null || a.length == 0)
            return null;
        T min = a[0];
        T max = a[0];

        for(int i = 1; i < a.length; i++) {
            if(min.compareTo(a[i]) > 0)
                min = a[i];
            if(max.compareTo(a[i]) < 0)
                max = a[i];
        }

        return new Pair<>(min, max);
    }


    public static <T> T getMiddle(T... a) {
        return a[a.length/2];
    }


    public static <T extends  Comparable> T min(T[] a) {
        if(a == null || a.length == 0)
            return null;
        T smallest = a[0];
        for(int i = 0; i < a.length; i++) {
            if(smallest.compareTo(a[i]) < 0)
                smallest = a[i];
        }

        return smallest;
    }



    public static <T> void addAll(Collection<T> coll, T... ts) {
        for(T t: ts) {
            coll.add(t);
        }
    }

}


