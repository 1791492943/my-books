package com.search_mysql;

import com.feign_api.pojo.Book;
import com.search_mysql.service.SearchBookService;
import com.search_mysql.utils.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

@SpringBootTest
public class TestPage {

    @Autowired
    private SearchBookService searchBookService;

    @Test
    void testPage(){
        Page<Book> page = new Page<>(1, 10);
        HashMap<String, Object> map = new HashMap<>();
        map.put("page",1);
        map.put("size",10);
        Page p = searchBookService.selectAllBook(map);
        p.setData();
        System.out.println(page.getTotal());
        System.out.println(books);
    }
}
