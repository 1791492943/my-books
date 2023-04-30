package com.search_mysql.controller;

import com.search_mysql.pojo.User;
import com.search_mysql.pojo.UserBookshelf;
import com.search_mysql.service.SearchBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search-mysql")
public class SearchBookController {

    @Autowired
    private SearchBookService searchBookService;
    @GetMapping("/login/{username}/{password}")
    public User login( @PathVariable("username") String username, @PathVariable("password") String password){
        User user = new User(username, password);
        User user1 = searchBookService.selectUserByUsernameAndPassword(user);
        System.out.println(user1);
        return user1;
    }

    @GetMapping("/login/{username}")
    public User login( @PathVariable("username") String username){
        System.out.println(username);
        return searchBookService.test(username);
    }

    @GetMapping("/selectAll")
    public List<User> selectAll(){
        return searchBookService.selectAll();
    }

    @GetMapping("/test")
    public List<UserBookshelf> selectAll1(){
        return searchBookService.selectAll1();
    }

}
