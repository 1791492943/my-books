package com.search_mysql.pojo;

import lombok.Data;

/**
 * 用户看书章节记录实体类
 */
@Data
public class UserLookBook {
    /**
     * id
     */
    private Integer id;
    /**
     * 用户id
     */
    private Integer user_id;
    /**
     * 书id
     */
    private Integer book_id;
    /**
     * 看到的章节
     */
    private Integer chapter;

}
