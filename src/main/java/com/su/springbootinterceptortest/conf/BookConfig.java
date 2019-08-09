package com.su.springbootinterceptortest.conf;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "book")
@Data
public class BookConfig {

    private String author;
    private String name;
}
