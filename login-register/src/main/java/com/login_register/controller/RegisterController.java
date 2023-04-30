package com.login_register.controller;

import com.login_register.pojo.R;
import com.login_register.pojo.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RegisterController {



    @PostMapping("/login")
    public R login(@RequestBody User user){
        return null;
    }

}
