package com.search_mysql.controller;

import com.feign_api.pojo.Book;
import com.feign_api.pojo.BookFile;
import com.feign_api.pojo.R;
import com.search_mysql.service.SearchBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.List;

@RestController
@RequestMapping("/search-mysql")
public class SearchBookController {

    @Autowired
    private SearchBookService searchBookService;

    @GetMapping("/selectBook/page/{page}/{size}")
    public R selectAllPage(@PathVariable("page") Integer page, @PathVariable("size") Integer size){
        Book book = Book.pagination(page, size);
        List<Book> books = searchBookService.selectAllBook(book);
        return R.succeed(books);//very good ---xjr
    }

    @GetMapping("/selectBook/{id}/{chapter}")
    public R selectBookChapter(@PathVariable("id") Integer id, @PathVariable("chapter") Integer chapter) throws IOException {
        BookFile bookFile = searchBookService.selectBookFileByBookId(id);
        if(bookFile == null){
            return R.error("小说或章节不存在");
        }
        String directory = bookFile.getDirectory();
        File file = new File(directory + "/" + chapter + ".txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = "";
        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null){
            sb.append(s);
        }
        br.close();
        return R.succeed(sb.toString());
    }

}
