package com.search_mysql.pojo;

import lombok.Data;

@Data
public class R<T> {

    private T data;
    private Integer code;
    private String msg;

    public static <T> R<T> succeed(T data){
        R<T> r = new R<>();
        r.setData(data);
        r.setCode(1);
        return r;
    }

    public static R<String> error(String msg){
        R<String> r = new R<>();
        r.setCode(0);
        r.setMsg(msg);
        return r;
    }
}
