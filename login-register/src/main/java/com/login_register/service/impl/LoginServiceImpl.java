package com.login_register.service.impl;

import com.feign_api.pojo.User;
import com.feign_api.pojo.UserDto;
import com.feign_api.utils.Jwt;
import com.login_register.mapper.LoginMapper;
import com.login_register.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginMapper loginMapper;



    @Override
    public UserDto loginByAccount(User user) {
        //影响查看密码 暂时不要加密
        /*//md5加密
        String password = user.getPassword();
        String md5Password = DigestUtils.md5DigestAsHex(password.getBytes());
        user.setPassword(md5Password);*/
        User u = loginMapper.loginByAccount(user);

        return getUserDto(user, u);
    }

    @Override
    public UserDto loginByPhone(User user) {
        User u = loginMapper.loginByPhone(user);
        return getUserDto(user, u);
    }

    @Override
    public UserDto loginByEmail(User user) {
        User u = loginMapper.loginByEmail(user);
        return getUserDto(user, u);
    }

    private static UserDto getUserDto(User user, User u) {
        if (u == null) return null;

        String token = Jwt.builder(user.getAccount());
        UserDto userDto = new UserDto(u);
        userDto.setToken(token);

        return userDto;
    }
}
