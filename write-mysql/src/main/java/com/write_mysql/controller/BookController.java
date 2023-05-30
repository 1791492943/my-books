package com.write_mysql.controller;

import com.feign_api.client.SearchMysqlServiceClient;
import com.feign_api.pojo.Book;
import com.feign_api.pojo.BookFile;
import com.feign_api.pojo.R;
import com.feign_api.pojo.User;
import com.feign_api.utils.Jwt;
import com.write_mysql.pojo.Update;
import com.write_mysql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/write-mysql")
public class BookController {

    @Autowired
    private BookService bookService;

    @Value("${book.path}")
    String path;
    @PostMapping("/createBook")
    public R<String> createBook(@RequestBody Book book,@RequestHeader("myBooksToken") String myBooksToken){
        bookService.createBook(book, myBooksToken, path);
        return R.succeed("创建成功");
    }

    @GetMapping("/selectBookFileByBookId/{bookId}")
    public R selectBookFileByBookId(@PathVariable Integer bookId){
        BookFile bookFile = bookService.selectBookFilesByBookId(bookId);
        return R.succeed(bookFile);
    }

    @PostMapping("/addChapter/{bookId}")
    public R addChapter(@PathVariable("bookId")Integer id, @RequestHeader("myBooksToken") String token) throws IOException {
        boolean bool = bookService.addChapter(id, token);
        if(!bool) return R.error("未知错误");
        return R.succeed("添加章节成功");
    }

    @PutMapping("/update/{bookId}/{chapter}")
    public R updateChapter(@RequestBody Update content, @PathVariable("bookId") Integer bookId, @PathVariable("chapter") Integer chapter, @RequestHeader("myBooksToken") String token) throws IOException {
        System.err.println(Thread.currentThread().getId());
        bookService.updateChapter(content.getContent(),bookId,chapter,token);
        return R.succeed("修改章节成功！");
    }


}
