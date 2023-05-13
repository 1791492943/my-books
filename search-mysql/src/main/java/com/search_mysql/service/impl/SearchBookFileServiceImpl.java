package com.search_mysql.service.impl;

import com.feign_api.pojo.BookFile;
import com.search_mysql.mapper.SearchBookFileMapper;
import com.search_mysql.service.SearchBookFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SearchBookFileServiceImpl implements SearchBookFileService {

    @Autowired
    private SearchBookFileMapper searchBookFileMapper;


    @Override
    public BookFile selectBookFileByBookId(int bookId) {
        BookFile bookFile = searchBookFileMapper.selectBookFileByBookId(bookId);
        return bookFile;
    }

    @Override
    public List<BookFile> selectBookFileByAccount(String account) {
        List<BookFile> bookFiles = searchBookFileMapper.selectBookFileByAccount(account);
        return bookFiles;
    }
}
