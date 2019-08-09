package com.su.springbootinterceptortest.been;


import lombok.Data;

@Data
public class ExceptionResponse {

    private String errorMsg;
    private String RequestURI;
}
