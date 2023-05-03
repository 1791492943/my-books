package com.feign_api.pojo;

import lombok.Data;

/**
 * 返回浏览器封装类 包含数据 状态码 异常信息
 * @param <T>
 */
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
