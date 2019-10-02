package com.su.springbootinterceptortest.utils.interfaces.impl;

import com.su.springbootinterceptortest.utils.interfaces.Interface1;
import org.springframework.stereotype.Service;

@Service(value = "impl1")
public class Impl1 implements Interface1 {

    @Override
    public void impl() {
        System.out.println("impl1 ");
    }

}
