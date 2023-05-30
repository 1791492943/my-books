package com.login_register.service;

import com.feign_api.pojo.User;
import com.feign_api.dto.UserDto;

public interface LoginService {


    /**
     * 账号登录
     * @param user 账号 密码
     * @return 用户对象 + token
     */
    UserDto loginByAccount(User user);

    /**
     * 手机号登录
     * @param user
     * @return
     */
    UserDto loginByPhone(User user);

    /**
     * 邮箱登录
     * @param user
     * @return
     */
    UserDto loginByEmail(User user);
}
