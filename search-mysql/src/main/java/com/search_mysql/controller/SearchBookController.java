package com.search_mysql.controller;

import com.feign_api.pojo.Book;
import com.feign_api.pojo.R;
import com.search_mysql.service.SearchBookService;
import com.search_mysql.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/search-mysql/book")
public class SearchBookController {

    @Autowired
    private SearchBookService searchBookService;

    @GetMapping("/page")
    public R<Page<Book>> page(@RequestParam HashMap<String,Object> map){
        System.err.println(Thread.currentThread().getId());
        Page page = searchBookService.selectAllBook(map);
        return R.succeed(page);
    }

    @GetMapping("/{id}")
    public R<Book> selectBookById(@PathVariable Integer id){
        Book book = searchBookService.selectBookById(id);
        return R.succeed(book);
    }

}
