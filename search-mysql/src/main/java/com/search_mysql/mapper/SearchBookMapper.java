package com.search_mysql.mapper;

import com.feign_api.pojo.Book;
import com.search_mysql.utils.Page;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Mapper
public interface SearchBookMapper {

    /**
     * 分页查询书
     * @param map
     * @return
     */
    List<Book> selectAllBook(HashMap map);

    /**
     * 根据id查询书
     * @param id
     * @return
     */
    @Select("select * from book where id = #{id};")
    Book selectBookById(int id);

    /**
     * 根据名称查书
     * @param name
     * @return
     */
    @Select("select * from book where name like #{name};")
    List<Book> selectBookByName(String name);

    /**
     * 根据作者查书
     * @param author
     * @return
     */
    @Select("select * from book where author like #{author};")
    List<Book> selectBookByAuthor(String author);

    /**
     * 根据类型查书
     * @param classify
     * @return
     */
    @Select("select * from book where classify = #{classify};")
    List<Book> selectBookByClassify(String classify);

    /**
     * 根据标签查书
     * @param label
     * @return
     */
    @Select("select * from book where label = #{label};")
    List<Book> selectBookByLabel(String label);


}
