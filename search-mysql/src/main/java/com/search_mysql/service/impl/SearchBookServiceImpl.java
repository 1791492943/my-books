package com.search_mysql.service.impl;

import com.feign_api.pojo.Book;
import com.search_mysql.mapper.SearchBookMapper;
import com.search_mysql.service.SearchBookService;
import com.search_mysql.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class SearchBookServiceImpl implements SearchBookService {
    @Autowired
    private SearchBookMapper searchBookMapper;

    @Override
    public Page selectAllBook(HashMap<String, Object> map) {
        if(map.get("name") != null){
            map.put("name","%" + map.get("name") + "%");
        }

        List<Book> books = searchBookMapper.selectAllBook(map);

        int page =  Integer.parseInt((String) map.get("page"));
        int size = Integer.parseInt((String) map.get("size"));
        Page<Book> p = new Page<>(page,size);
        p.setTotal(books.size());
        p.setData(books);
        return p;
    }

    @Override
    public Book selectBookById(int id) {
        Book book = searchBookMapper.selectBookById(id);
        return book;
    }

    @Override
    public List<Book> selectBookByName(String name) {
        name = "%" + name + "%";
        List<Book> books = searchBookMapper.selectBookByName(name);
        return books;
    }

    @Override
    public List<Book> selectBookByAuthor(String author) {
        author = "%" + author + "%";
        List<Book> books = searchBookMapper.selectBookByAuthor(author);
        return books;
    }

    //TODO 数据库还没把表弄出来 先不搞了
    @Override
    public List<Book> selectBookByClassify(String classify) {
        return null;
    }

    //TODO 数据库还没把表弄出来 先不搞了
    @Override
    public List<Book> selectBookByLabel(String label) {
        return null;
    }
}
