package com.search_mysql.controller;

import com.search_mysql.mapper.SearchBookMapper;
import com.search_mysql.pojo.R;
import com.search_mysql.pojo.User;
import com.search_mysql.pojo.UserBookshelf;
import com.search_mysql.pojo.UserDto;
import com.search_mysql.service.SearchBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search-mysql")
public class SearchBookController {
    @Autowired
    private SearchBookMapper searchBookMapper;

    @Autowired
    private SearchBookService searchBookService;

    @GetMapping("/selectAll")
    public List<User> selectAll(){
        return searchBookMapper.selectAll();
    }

    /**
     * 注册账户
     * @param user 封装好的对象
     * @return 账户信息
     */
    @PostMapping("/register")
    public R register(@RequestBody User user){
        searchBookService.register(user);
        searchBookService.registerAccount(user);
        return R.succeed(user.getId());
    }

    @PostMapping("/login")
    public R login(@RequestBody User user) {
        UserDto userDto = searchBookService.login(user);
        if(userDto == null){
            return R.error("用户名或密码错误!");
        }

        return R.succeed(userDto.getToken());
    }

}
