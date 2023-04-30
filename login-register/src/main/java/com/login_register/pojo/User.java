package com.login_register.pojo;

import lombok.Data;

/**
 * 用户实体类
 */
@Data
public class User {
    /**
     * id
     */
    private Integer id;
    /**
     * 名称
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 账号
     */
    private String account;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机
     */
    private String phone;

}
