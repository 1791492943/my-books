package com.feign_api.client;

import com.feign_api.pojo.Book;
import com.feign_api.pojo.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("search-mysql")
public interface SearchMysqlServiceClient {
    @GetMapping("/search-mysql/book/{id}")
    R<Book> selectBookById(@PathVariable("id") Integer id);
}
