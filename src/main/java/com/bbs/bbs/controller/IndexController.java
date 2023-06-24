package com.bbs.bbs.controller;

import com.bbs.bbs.mapper.UserLoginMapper;
import com.bbs.bbs.mapper.UserMapper;
import com.bbs.bbs.model.User;
import com.bbs.bbs.model.UserLogin;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserLoginMapper userLoginMapper;
    @GetMapping("/")
    public String index(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        UserLogin userLogin = new UserLogin();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("token")){
                String token = cookie.getValue();
                userLogin = userLoginMapper.SelectByToken(token);
                if (userLogin!=null){
                    request.getSession().setAttribute("user",userLogin);
                }
                break;
            }
        }
        return "index";
    }
}
