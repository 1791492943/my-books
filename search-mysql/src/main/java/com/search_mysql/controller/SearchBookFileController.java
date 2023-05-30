package com.search_mysql.controller;

import com.search_mysql.service.SearchBookFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/search-mysql/bookFile")
public class SearchBookFileController {

    @Autowired
    private SearchBookFileService searchBookFileService;



}
