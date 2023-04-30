package com.search_mysql.service.impl;

import com.search_mysql.mapper.SearchBookMapper;
import com.search_mysql.pojo.User;
import com.search_mysql.pojo.UserDto;
import com.search_mysql.service.SearchBookService;
import com.search_mysql.util.Jwt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SearchBookServiceImpl implements SearchBookService {

    @Autowired
    private SearchBookMapper searchBookMapper;


    @Override
    public int register(User user) {
        return searchBookMapper.register(user);
    }

    @Override
    public int registerAccount(User user) {
        return searchBookMapper.registerAccount(user);
    }

    @Override
    public UserDto login(User user) {
        User u = searchBookMapper.login(user);
        if(u == null){
            return null;
        }
        String token = Jwt.builder(user.getUsername());
        UserDto userDto = new UserDto(u);
        userDto.setToken(token);
        return userDto;
    }
}
