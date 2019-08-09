package com.su.springbootinterceptortest.exception;

import com.su.springbootinterceptortest.been.ExceptionResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ExceptionResponse exception(Exception e, HttpServletRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse();

        exceptionResponse.setErrorMsg(e.getMessage());
        exceptionResponse.setRequestURI(request.getRequestURI());
        return exceptionResponse;
    }
}
