package com.login_register.service;

import com.feign_api.pojo.User;

public interface RegisterService {
    /**
     * 注册第一步 设置用户名密码
     * @param user 用户名密码
     * @return 影响的行数，并设置id到user对象中
     */
    int register(User user);

    /**
     * 注册第二步 设置账号
     * @param user 用户id
     * @return 影响的行数
     */
    int registerAccount(User user);
}
