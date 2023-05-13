package com.search_mysql.service;


import com.feign_api.pojo.BookFile;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SearchBookFileService {

    /**
     * 根据书本id 查询书本文件
     * @param bookId
     * @return
     */
    @Select("select * from book_file where book_id = #{bookId}")
    BookFile selectBookFileByBookId(int bookId);

    /**
     * 根据用户账号 查询书本文件
     * @param account
     * @return
     */
    @Select("select * from book_file where account = #{account}")
    List<BookFile> selectBookFileByAccount(String account);

}
