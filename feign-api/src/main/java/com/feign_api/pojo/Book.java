package com.feign_api.pojo;

import lombok.Data;

/**
 * 书本实体类
 */
@Data
public class Book {
    /**
     * id
     */
    private Integer id;
    /**
     * 书名
     */
    private String name;
    /**
     * 章节
     */
    private Integer chapter;
    /**
     * 字数
     */
    private Integer count;
    /**
     * 介绍
     */
    private String introduce;
    /**
     * 标签
     */
    private String label;
    /**
     * 更新时间
     */
    private String updateDate;
    /**
     * 作者
     */
    private String author;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 图片
     */
    private String image;
    /**
     * 分类
     */
    private String classify;
    /**
     * 分页-当前页 非数据库字段
     */
    private Integer page;
    /**
     * 分页-显示条数 非数据库字段
     */
    private Integer size;

    public static Book pagination(int page, int size){
        Book book = new Book();

        if(page <= 0 || size <= 0){
            book.setPage(0);
            book.setSize(50);
            return book;
        }

        book.setPage((page-1) * size);
        book.setSize(size);
        return book;
    }

}
