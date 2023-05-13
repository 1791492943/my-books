package com.write_mysql.config;

import com.feign_api.pojo.R;
import com.write_mysql.exception.ServiceException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionInterceptor {
    @ExceptionHandler(ServiceException.class)
    public R serviceException(ServiceException e){
        return R.error(e.getMessage());
    }
}
