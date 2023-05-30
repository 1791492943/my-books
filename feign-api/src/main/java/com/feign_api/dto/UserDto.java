package com.feign_api.dto;

import com.feign_api.pojo.User;
import lombok.Data;

/**
 * 用户实体封装类 加了Token
 */
@Data
public class UserDto {
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
    private String token;


    public UserDto(User u) {
        this.id = u.getId();
        this.username = u.getUsername();
        this.password = u.getPassword();
        this.account = u.getAccount();
        this.email = u.getEmail();
        this.phone = u.getPhone();
    }
}
