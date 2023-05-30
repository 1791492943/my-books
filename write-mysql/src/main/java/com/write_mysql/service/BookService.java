package com.write_mysql.service;

import com.feign_api.pojo.Book;
import com.feign_api.pojo.BookFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface BookService {
    boolean createBook(Book book,String myBooksToken, String path);

    BookFile selectBookFilesByBookId(Integer bookId);

    boolean addChapter(Integer id, String token) throws IOException;

    void updateChapter(String content, Integer bookId, Integer chapter, String token) throws IOException;
}
