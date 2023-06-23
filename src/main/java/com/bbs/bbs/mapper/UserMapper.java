package com.bbs.bbs.mapper;

import com.bbs.bbs.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO user(name, account_id, token, gmt_create, gmt_modified) " +
            "VALUES (#{name}, #{accountId}, #{token}, #{gmtCreate}, #{gmtModified})")
    int insert(User user);
    @Select("select * from user where token = #{token}")
    User findByToken(@Param("token") String token);
}
