package com.login_register.controller;

import com.feign_api.pojo.R;
import com.feign_api.pojo.User;
import com.login_register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    /**
     * 注册账户
     * @param user 封装好的对象
     * @return 账户信息
     */
    @PostMapping("/register")
    public R register(@RequestBody User user){
        registerService.register(user);
        registerService.registerAccount(user);
        return R.succeed(user.getAccount());
    }

}
