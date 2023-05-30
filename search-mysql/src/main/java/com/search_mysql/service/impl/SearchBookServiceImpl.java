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

        Object page1 =  map.get("page");
        Object size1 =  map.get("size");

        if(page1 == null || size1 == null){
            map.put("page",0);
            map.put("size",10);
        }else if(Integer.parseInt(page1.toString()) <= 0 || Integer.parseInt(size1.toString()) <= 0 || Integer.parseInt(size1.toString()) > 100){
            map.put("page",0);
            map.put("size",10);
        }else{
            int p = Integer.parseInt(page1.toString());
            int s = Integer.parseInt(size1.toString());
            map.put("page", (p-1)*s);
            map.put("size",s);
        }

        List<Book> books = searchBookMapper.selectAllBook(map);

        int page = (int) map.get("page");
        int size = (int) map.get("size");
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
