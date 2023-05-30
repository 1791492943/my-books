package com.search_mysql.utils;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {

    private List<T> data;
    private Integer page;
    private Integer size;
    private Integer total;

    /**
     * 分页
     * @param page 页码
     * @param size 显示条数
     */
    public Page(Integer page, Integer size) {
        this.page = page * size + 1;
        this.size = size;
    }
}
