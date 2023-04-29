package com.gateway.feign;

import com.gateway.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("search-mysql")
public interface SearchMysqlClient {
    @GetMapping("/login/{username}/{password}")
    User login(@PathVariable String username, @PathVariable String password);
}
