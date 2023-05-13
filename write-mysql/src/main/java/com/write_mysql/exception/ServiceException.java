package com.write_mysql.exception;

public class ServiceException extends RuntimeException{

    private String msg;

    public ServiceException(String message) {
        this.msg = message;
    }
}
