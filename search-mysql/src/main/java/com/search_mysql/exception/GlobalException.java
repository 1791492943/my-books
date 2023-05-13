package com.search_mysql.exception;

import com.feign_api.pojo.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

/*    @ExceptionHandler(RuntimeException.class)
    public R<String> runTimeException(RuntimeException e){
        return R.error("意料之外的错误！");
    }*/

}
