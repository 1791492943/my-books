package com.write_mysql.service.impl;

import com.feign_api.client.SearchMysqlServiceClient;
import com.feign_api.pojo.Book;
import com.feign_api.pojo.BookFile;
import com.feign_api.pojo.User;
import com.feign_api.utils.Jwt;
import com.write_mysql.exception.ServiceException;
import com.write_mysql.mapper.BookMapper;
import com.write_mysql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private SearchMysqlServiceClient searchMysqlServiceClient;

    @Override
    @Transactional()
    public boolean createBook(Book book, String myBooksToken, String path) {
        bookMapper.createBook(book);
        //从token获取账号
        String account = Jwt.parseToAccount(myBooksToken);

        BookFile bookFile = new BookFile();
        bookFile.setAccount(account);
        bookFile.setBookId(book.getId());
        path = path.endsWith("\\") ? path : path + "\\";
        bookFile.setDirectory(path + book.getId() + "-" + book.getName());
        boolean mkdirs = new File(bookFile.getDirectory()).mkdirs();
        if (!mkdirs) throw new RuntimeException("创建文件失败，回滚数据库操作");
        bookMapper.createBookDirectory(bookFile);
        return true;
    }

    @Override
    public BookFile selectBookFilesByBookId(Integer bookId) {
        return bookMapper.selectBookFilesByBookId(bookId);
    }

    @Override
    @Transactional(rollbackFor = {IOException.class})
    public boolean addChapter(Integer id, String token) throws IOException {
        //查询书文件
        BookFile bookFile = bookMapper.selectBookFilesByBookId(id);
        //获取token的账号
        String account = Jwt.parseToAccount(token);
        //判断书创建人账号 和 token的账号是否一致
        boolean equals = bookFile.getAccount().equals(account);
        if(!equals) throw new ServiceException("账号验证失败！");

        Integer bookId = bookFile.getBookId();
        Book book = searchMysqlServiceClient.selectBookById(bookId).getData();

        String directory = bookFile.getDirectory();
        boolean exists = new File(directory + "\\" + (book.getChapter()+1) + ".txt").exists();
        if(exists) throw new ServiceException("章节已存在！");

        new File(directory + "\\" + (book.getChapter()+1) + ".txt").createNewFile();

        int i = bookMapper.addChapter(id);
        if(i != 1) throw new ServiceException("未知错误！");
        return true;
    }

    @Override
    public void updateChapter(String content, Integer bookId, Integer chapter, String token) throws IOException {
        BookFile bookFile = bookMapper.selectBookFilesByBookId(bookId);

        String directory = bookFile.getDirectory();
        File file = new File(directory + "\\" + chapter + ".txt");

        boolean exists = file.exists();
        if(!exists) throw new ServiceException("章节不存在！");

        FileOutputStream outputStream = new FileOutputStream(file, false);
        outputStream.write(content.getBytes());

        outputStream.close();
    }


}
