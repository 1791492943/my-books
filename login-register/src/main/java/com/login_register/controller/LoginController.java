package com.login_register.controller;

import com.feign_api.pojo.R;
import com.feign_api.pojo.User;
import com.feign_api.pojo.UserDto;
import com.login_register.mapper.RegisterMapper;
import com.login_register.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private RegisterMapper registerMapper;

    /**
     * 根据账号登录
     * @param user 账号 密码
     * @return token
     */
    @PostMapping("/login")
    public R loginByAccount(@RequestBody User user) {
        UserDto userDto = loginService.loginByAccount(user);
        if(userDto == null){
            return R.error("用户名或密码错误!");
        }
        //不要返回密码
        userDto.setPassword(null);
        return R.succeed(userDto);
    }

}
