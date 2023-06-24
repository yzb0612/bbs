package com.bbs.bbs.controller;

import com.bbs.bbs.mapper.UserLoginMapper;
import com.bbs.bbs.mapper.UserMapper;
import com.bbs.bbs.model.User;
import com.bbs.bbs.model.UserLogin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
public class LoginController {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserLoginMapper userLoginMapper;
    @PostMapping("/login")
    public String PostLogin(
            @RequestParam("username")String username,
            @RequestParam("password")String password,
            HttpServletResponse response,
            HttpServletRequest request
    ){
        User user = userMapper.findByName(username,password);
        UserLogin userLogin = new UserLogin();
        if (user.getName()!=null){
            String token = UUID.randomUUID().toString();
            userLogin.setToken(token);
            userLogin.setName(user.getName());
            userLogin.setGmtCreate(user.getGmtCreate());
            userLogin.setGmtModified(user.getGmtModified());
            userLoginMapper.InsertUserLogin(userLogin);
            response.addCookie(new Cookie("token",token));
            request.getSession().setAttribute("user",userLogin);
            return "index";
        }
        return "/login";
    }
    @GetMapping("/login")
    public String GetLogin(
    ){
        return "login";
    }
}
