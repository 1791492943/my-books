package com.login_register.service;

import com.feign_api.pojo.User;

public interface SelectUserService {

    User selectUserByAccount(User user);

}
