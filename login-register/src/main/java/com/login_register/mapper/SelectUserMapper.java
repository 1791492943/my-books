package com.login_register.mapper;

import com.feign_api.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SelectUserMapper {

    @Select("select * from user where account = #{account}")
    User selectUserByAccount(User user);

}
