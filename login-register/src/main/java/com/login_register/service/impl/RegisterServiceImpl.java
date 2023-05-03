package com.login_register.service.impl;

import com.feign_api.pojo.User;
import com.login_register.mapper.RegisterMapper;
import com.login_register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterMapper registerMapper;
    @Override
    public int register(User user) {
        //影响查看密码 暂时不要加密
        /*//md5加密
        String password = user.getPassword();
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        user.setPassword(md5Password);*/
        return registerMapper.register(user);
    }

    @Override
    public int registerAccount(User user) {
        //账号从10000开始
        user.setAccount(String.valueOf(user.getId()+9999));
        return registerMapper.registerAccount(user);
    }
}
