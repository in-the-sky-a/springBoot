package com.su.springbootinterceptortest.utils.interfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeSortTest {

    public static void main(String args[]) {
        Employee[] employees = new Employee[4];
        employees[0] = new Employee("auuuuuu", 1000);
        employees[1] = new Employee("bb", 5000);
        employees[2] = new Employee("crrr", 4000);
        employees[3] = new Employee("bb", 2000);

        print(employees);

/*
        Arrays.sort(employees);
*/

       /* Arrays.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getName().length() - o2.getName().length();
            }
        });*/


        /*Arrays.sort(employees, (o1, o2) -> {
            return o1.getName().length() - o2.getName().length();
        });

        Arrays.sort(employees, (o1, o2) -> o1.getName().length() - o2.getName().length());
*/
        Arrays.sort(employees, Comparator.comparing(Employee::getName).thenComparing(Employee::getAge));
        print(employees);

        //streamTest();





    }

    /**
     * lambada构造器引用
     */
    private static void streamTest() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("su");
        arrayList.add("yan");
        arrayList.add("aegfds");
        List<Person> collect = arrayList.stream().map(Person::new).collect(Collectors.toList());

        Person[] people = arrayList.stream().toArray(Person[]::new);

    }

    /*private static void streamTest2() {
        ArrayList<Man> arrayList = new ArrayList<>();
        Man man1 = new Man("a", 1);
        Man man2 = new Man("b", 2);

        arrayList.add(man1);
        arrayList.add(man2);

        arrayList.stream().map(Employee[]::new)


    }*/

    private static void print(Employee[] employees) {
        for (Employee e : employees) {
            System.out.printf(e.getName() + "-"+ e.getAge() + " ");
        }
        System.out.println();
    }

}

