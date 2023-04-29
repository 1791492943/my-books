package com.search_mysql.mapper;

import com.search_mysql.pojo.User;
import com.search_mysql.util.ChineseNumToArabicNumUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.io.*;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Mapper
public interface SearchBookMapper {
    
    @Select("select * from user where username = #{username} and password = #{password}")
    User selectUserByUsernameAndPassword(User user);

    @Select("select * from user where username = #{username}")
    User test(String username);

    @Select("select * from user;")
    List<User> selectAll();

}
