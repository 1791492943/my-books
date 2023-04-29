package com.search_mysql.service.impl;

import com.search_mysql.mapper.SearchBookMapper;
import com.search_mysql.pojo.User;
import com.search_mysql.service.SearchBookService;
import com.search_mysql.util.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchBookServiceImpl implements SearchBookService {

    @Autowired
    private SearchBookMapper searchBookMapper;

    @Override
    public User selectUserByUsernameAndPassword(User user) {
        User user1 = searchBookMapper.selectUserByUsernameAndPassword(user);
        if(user != null){
            String token = Jwt.builder(user1.getUsername());
            System.out.println(token);
        }
        return user1;
    }

    @Override
    public User test(String username) {
        return searchBookMapper.test(username);
    }

    @Override
    public List<User> selectAll() {
        return searchBookMapper.selectAll();
    }
}
