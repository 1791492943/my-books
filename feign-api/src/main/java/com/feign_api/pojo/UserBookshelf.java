package com.feign_api.pojo;

import lombok.Data;

/**
 * 书架实体类
 */
@Data
public class UserBookshelf {
    private Integer id;
    private Integer userId;
    private Integer bookId;

}
