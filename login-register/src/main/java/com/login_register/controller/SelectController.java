package com.login_register.controller;

import com.feign_api.pojo.R;
import com.feign_api.pojo.User;
import com.login_register.service.SelectUserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class SelectController {

    @Autowired
    private SelectUserService selectUserService;

    @PostMapping("/selectUser")
    public R<User> selectUserByAccount(@RequestBody User user){
        User user1 = selectUserService.selectUserByAccount(user);
        return R.succeed(user1);
    }

}
