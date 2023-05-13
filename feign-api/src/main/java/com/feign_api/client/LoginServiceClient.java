package com.feign_api.client;

import com.feign_api.pojo.R;
import com.feign_api.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("login-register")
public interface LoginServiceClient {
    @PostMapping("/selectUser")
    R<User> selectUserByAccount(@RequestBody User user);

}
