package com.bbs.bbs.mapper;

import com.bbs.bbs.model.User;
import com.bbs.bbs.model.UserLogin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserLoginMapper {
 @Insert("insert into userlogin(name,token,gmt_create,gmt_modified) values(#{name},#{token},#{gmtCreate},#{gmtModified})")
    int InsertUserLogin(UserLogin userLogin);
 @Select("select * from userlogin where token = #{token}")
    UserLogin SelectByToken(@Param("token") String token);
}
