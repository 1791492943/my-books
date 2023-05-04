package com.search_mysql.service.impl;

import com.feign_api.pojo.Book;
import com.feign_api.pojo.BookFile;
import com.search_mysql.mapper.SearchBookMapper;
import com.search_mysql.service.SearchBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SearchBookServiceImpl implements SearchBookService {

    @Autowired
    private SearchBookMapper searchBookMapper;


    @Override
    public List<Book> selectAllBook(Book book) {
        return searchBookMapper.selectAllBook(book);
    }

    @Override
    public Book selectBookById(int id) {
        return searchBookMapper.selectBookById(id);
    }

    @Override
    public BookFile selectBookFileByBookId(int id) {
        return searchBookMapper.selectBookFileByBookId(id);
    }
}
