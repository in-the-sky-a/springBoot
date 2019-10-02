package com.su.springbootinterceptortest.controller;

import com.su.autoconfig.HelloService;
import com.su.springbootinterceptortest.conf.BookConfig;
import com.su.springbootinterceptortest.utils.interfaces.Interface1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;

@Controller
public class MainController {

    @Autowired
    private BookConfig bookConfig;
    @Autowired
    private HelloService helloService;

    @Autowired
    @Qualifier(value = "impl1")
    private Interface1 interface1;

    @RequestMapping(value = {"/", "/test"})
    public String test(Model model) {

        System.out.println("\n-------- MainController.test --- ");

        System.out.println(" ** You are in Controller ** ");

        return "test";
    }

    // This path is no longer used.
    // It will be redirected by OldLoginInterceptor
    @Deprecated
    @RequestMapping(value = {"/admin/oldLogin"})
    public String oldLogin(Model model) {

        // Code here never run.
        return "oldLogin";
    }

    @RequestMapping(value = {"/admin/login"})
    public String login(Model model) {

        System.out.println("\n-------- MainController.login --- ");

        System.out.println(" ** You are in Controller ** ");

        return "login";
    }

    @RequestMapping(value = "admin/exceptionTest")
    public String test() throws IOException {

        //just throw exception to test the exceptionhandler mapping
        if (true) {
            throw new IOException("this is io exception");
        }

        // render hello.jsp page
        return "login";
    }

    @RequestMapping(value = "admin/book")
    public @ResponseBody
    String book() {
        return "author: " + bookConfig.getAuthor() + ", name: " + bookConfig.getName();
    }

    @RequestMapping(value = "autoconfig")
    public @ResponseBody
    String autoConfig() {
        return helloService.sayHello();
    }


    @RequestMapping(value = "interface")
    @ResponseBody
    public void interfaceTest() {
        interface1.impl();

    }


}