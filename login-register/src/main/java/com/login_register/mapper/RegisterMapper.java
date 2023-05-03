package com.login_register.mapper;

import com.feign_api.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface RegisterMapper {
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
    @Update("update user set account = #{account} where id = #{id};")
    int registerAccount(User user);
}
