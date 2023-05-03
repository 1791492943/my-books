package com.login_register.mapper;

import com.feign_api.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface LoginMapper {

    /**
     * 根据账号登录
     * @param user
     * @return
     */
    @Select("select * from user where account = #{account} and password = #{password};")
    User loginByAccount(User user);

    /**
     * 根据手机号登录
     * @return
     */
    @Select("select * from user where phone = #{phone} and password = #{password};")
    User loginByPhone(User user);

    /**
     * 根据邮箱登录
     * @return
     */
    @Select("select * from user where email = #{email} and password = #{password};")
    User loginByEmail(User user);
}
