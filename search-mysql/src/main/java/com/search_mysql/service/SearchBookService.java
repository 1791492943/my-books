package com.search_mysql.service;

import com.search_mysql.pojo.User;
import com.search_mysql.pojo.UserBookshelf;

import java.util.List;

public interface SearchBookService {

    User selectUserByUsernameAndPassword(User user);
    User test(String username);
    List<User> selectAll();
    List<UserBookshelf> selectAll1();

}
