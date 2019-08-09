package com.su.springbootinterceptortest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringbootinterceptortestApplication {


    @Value("${book.author}")
    private String author;

    @RequestMapping("/author")
    @ResponseBody
    String index() {
        return "author is: " + author;
    }

    public static void main(String[] args) {

        SpringApplication.run(SpringbootinterceptortestApplication.class, args);


    }

}
