package com.search_mysql.mapper;

import com.search_mysql.pojo.User;
import com.search_mysql.pojo.UserBookshelf;
import com.search_mysql.util.ChineseNumToArabicNumUtil;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SearchBookMapper {

    @Select("select * from user;")
    List<User> selectAll();

    /**
     * 注册账户
     * @param user
     * @return
     */
    @Insert("insert into user (id,username, password) values (null,#{username},#{password});")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int register(User user);

    /**
     * 设置账户
     * @param user
     * @return
     */
    @Update("update user set account = #{id} where id = #{id};")
    int registerAccount(User user);

    @Select("select * from user where account = #{account} and password = #{password};")
    User login(User user);


}
