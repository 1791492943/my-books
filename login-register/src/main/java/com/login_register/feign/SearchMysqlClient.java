package com.login_register.feign;

import com.login_register.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("search-mysql")
public interface SearchMysqlClient {
    @GetMapping("/login/{username}/{password}")
    User login(@PathVariable String username, @PathVariable String password);
}
