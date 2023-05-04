package com.search_mysql.mapper;

import com.feign_api.pojo.Book;
import com.feign_api.pojo.BookFile;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface SearchBookMapper {

    @Select("select * from book limit #{page},#{size};")
    List<Book> selectAllBook(Book book);

    @Select("select * from book where id = #{id};")
    Book selectBookById(int id);

    @Select("select * from book_file where book_id = #{id}")
    BookFile selectBookFileByBookId(int id);
}
