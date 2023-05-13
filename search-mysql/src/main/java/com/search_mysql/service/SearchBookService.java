package com.search_mysql.service;


import com.feign_api.pojo.Book;
import com.search_mysql.utils.Page;
import org.apache.ibatis.annotations.Select;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface SearchBookService {

    /**
     * 分页查询书
     * @param map
     * @return
     */
    Page selectAllBook(HashMap<String, Object> map);

    /**
     * 根据id查询书
     * @param id
     * @return
     */
    Book selectBookById(int id);

    /**
     * 根据名称查书
     * @param name
     * @return
     */
    List<Book> selectBookByName(String name);

    /**
     * 根据作者查书
     * @param author
     * @return
     */
    List<Book> selectBookByAuthor(String author);

    /**
     * 根据类型查书
     * @param classify
     * @return
     */
    List<Book> selectBookByClassify(String classify);

    /**
     * 根据标签查书
     * @param label
     * @return
     */
    List<Book> selectBookByLabel(String label);


}
