package com.bbs.bbs.mapper;

import com.bbs.bbs.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user(name, password,  gmt_create, gmt_modified) " +
            "VALUES (#{name}, #{password}, #{gmtCreate}, #{gmtModified})")
    int insert(User user);
    @Select("select * from user where name = #{username} and password = #{password}")
    User findByName(@Param("username") String username,@Param("password")String password);
    @Select("select * from user where name = #{token}")
    User findByToken(@Param("token") String token);
}
