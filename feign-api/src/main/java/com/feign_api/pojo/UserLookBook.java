package com.feign_api.pojo;

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
    private Integer userId;
    /**
     * 书id
     */
    private Integer bookId;
    /**
     * 看到的章节
     */
    private Integer chapter;

}
