package com.feign_api.pojo;

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
     * 用户账号
     */
    private String account;
    /**
     * 书id
     */
    private Integer bookId;
    /**
     * 书目录
     */
    private String directory;

}
