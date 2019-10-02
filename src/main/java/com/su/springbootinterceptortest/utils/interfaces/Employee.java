package com.su.springbootinterceptortest.utils.interfaces;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee implements Comparable<Employee>{

    private String name;
    private int age;
    private double salary;

    Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }


    @Override
    public int compareTo(Employee o) {
        return Double.compare(this.salary, o.salary);
    }

}
