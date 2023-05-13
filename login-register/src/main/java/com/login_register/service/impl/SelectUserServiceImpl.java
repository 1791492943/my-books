package com.login_register.service.impl;

import com.feign_api.pojo.User;
import com.login_register.mapper.SelectUserMapper;
import com.login_register.service.SelectUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SelectUserServiceImpl implements SelectUserService {

    @Autowired
    private SelectUserMapper selectUserMapper;

    @Override
    public User selectUserByAccount(User user) {
        return selectUserMapper.selectUserByAccount(user);
    }
}
