package com.search_mysql.service.impl;

import com.feign_api.pojo.BookFile;
import com.search_mysql.mapper.SearchBookFileMapper;
import com.search_mysql.service.SearchBookFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
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

    @Override
    public String lookBook(Integer bookId, Integer chapter) throws IOException {
        BookFile bookFile = searchBookFileMapper.lookBook(bookId);
        String directory = bookFile.getDirectory();
        File file = new File(directory);

        if (!file.exists()) {
            System.out.println("没有这本书");
        }


        BufferedReader br = new BufferedReader(new FileReader(directory + "\\" + chapter + ".txt"));
        StringBuilder sb = new StringBuilder();
        String s;

        while ((s = br.readLine()) != null) {
            sb.append(s).append("<br>");
        }

        br.close();

        return sb.toString();
    }
}
