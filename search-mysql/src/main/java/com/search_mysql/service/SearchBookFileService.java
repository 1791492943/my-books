package com.search_mysql.service;


import com.feign_api.pojo.BookFile;
import org.apache.ibatis.annotations.Select;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface SearchBookFileService {

    /**
     * 根据书本id 查询书本文件
     * @param bookId
     * @return
     */
    BookFile selectBookFileByBookId(int bookId);

    /**
     * 根据用户账号 查询书本文件
     * @param account
     * @return
     */
    List<BookFile> selectBookFileByAccount(String account);

    /**
     * 查看章节
     * @param bookId 书id
     * @param chapter 章节
     * @return
     */
    String lookBook(Integer bookId, Integer chapter) throws IOException;

}
