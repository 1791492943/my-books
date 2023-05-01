package com.feign_api.client;

import com.feign_api.pojo.R;
import com.feign_api.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("search-mysql")
public interface SearchMysqlClient {
    @PostMapping("/search-mysql/register")
    R register(User user);
}
