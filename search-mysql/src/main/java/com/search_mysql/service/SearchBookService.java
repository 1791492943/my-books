package com.search_mysql.service;

import com.feign_api.pojo.Book;
import com.feign_api.pojo.BookFile;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface SearchBookService {

    List<Book> selectAllBook(Book book);

    Book selectBookById(int id);

    BookFile selectBookFileByBookId(int id);
}
