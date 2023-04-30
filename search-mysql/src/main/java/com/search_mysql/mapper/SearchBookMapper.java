package com.search_mysql.mapper;

import com.search_mysql.pojo.User;
import com.search_mysql.pojo.UserBookshelf;
import com.search_mysql.util.ChineseNumToArabicNumUtil;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SearchBookMapper {

    //后续转移到登陆注册模块
    @Select("select * from user where username = #{username} and password = #{password}")
    User selectUserByUsernameAndPassword(User user);
    //测试方法 后续删除
    @Select("select * from user where username = #{username}")
    User test(String username);
    //测试方法 后续删除
    @Select("select * from user;")
    List<User> selectAll();

    //测试方法 后续删除
    @Select("select * from user_bookshelf;")
    List<UserBookshelf> selectAll1();


}
