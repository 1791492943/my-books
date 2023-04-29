package com.search_mysql.pojo;

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

}
