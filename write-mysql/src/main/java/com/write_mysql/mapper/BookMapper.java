package com.write_mysql.mapper;

import com.feign_api.pojo.Book;
import com.feign_api.pojo.BookFile;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    /**
     * 添加书籍 第一步创建书本返回id到book对象中
     * @param book 书籍信息
     * @return 影响的行数
     */
    @Insert("insert into " +
            "book (id, name, chapter, count, introduce, label, update_date, author, create_time, image, classify) " +
            "values (null, #{name}, 0, 0, #{introduce}, #{label}, now(), #{author}, now(), #{image}, #{classify});")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int createBook(Book book);

    /**
     * 添加书籍 第二步 在书本文件表中添加 用户id 书本id 目录 三者绑定
     * @param bookFile
     * @return 影响的行数
     */
    @Insert("insert into " +
            "book_file (id, user_id, book_id, directory) " +
            "values (null, #{userId}, #{bookId}, #{directory});")
    int createBookDirectory(BookFile bookFile);

    @Select("select * from book_file where user_id = #{userId};")
    List<BookFile> selectBookFilesByUserId(Integer userId);

    @Select("select * from book_file where book_id = #{bookId};")
    BookFile selectBookFilesByBookId(Integer bookId);

    @Update("update book set chapter = chapter+1 where id = #{id};")
    int addChapter(Integer id);

    @Select("select * from book where id = #{id};")
    Book selectBookById(Integer id);
}
