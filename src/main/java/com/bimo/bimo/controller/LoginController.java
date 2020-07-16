package com.bimo.bimo.controller;

import com.bimo.bimo.annotation.UserLoginToken;
import com.bimo.bimo.config.JwtToken;
import com.bimo.bimo.dao.Resultful;
import com.bimo.bimo.dao.UserDao;
import com.bimo.bimo.pojo.MyResponse;
import com.bimo.bimo.pojo.User;
import com.bimo.bimo.pojo.UserAndToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/**
 * TOKEN 有效期 1 周？ 还是1天吧
 * 刷新时间为.6~1天
 *
 * */
@RestController
@RequestMapping("/login")
public class LoginController {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping
    public Resultful getLoginPage() {
        return new Resultful(200, "登陆界面获取成功！");
    }

    @PostMapping
    public MyResponse Login(String username, String password) {
        User user = userDao.getUserByUsername(username);
        if (user == null) {
            return new MyResponse("当前用户不存在！", HttpStatus.NOT_FOUND);
        }
        if (user.checkPassword(password)) {

            return new MyResponse(new UserAndToken(user, JwtToken.createJWT(user)), HttpStatus.OK);
        }
        return new MyResponse("密码错误，请重试！", HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    @UserLoginToken
    public String updateLogin() {
        return "Login！";
    }
}
