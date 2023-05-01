package com.login_register.controller;

import com.feign_api.client.SearchMysqlClient;
import com.feign_api.pojo.R;
import com.feign_api.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RegisterController {

    @Autowired
    private SearchMysqlClient searchMysqlClient;

    @PostMapping("/register")
    public R register(@RequestBody User user){
        return searchMysqlClient.register(user);
    }

}
