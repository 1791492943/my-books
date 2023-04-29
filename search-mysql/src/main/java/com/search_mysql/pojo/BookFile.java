package com.search_mysql.pojo;

import lombok.Data;

/**
 * 书本文件实体类
 */
@Data
public class BookFile {
    /**
     * id
     */
    private Integer id;
    /**
     * 书id
     */
    private Integer bookId;
    /**
     * 书目录
     */
    private String directory;

}
