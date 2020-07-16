package com.bimo.bimo.controller;


import com.bimo.bimo.config.JwtToken;
import com.bimo.bimo.pojo.MyResponse;
import com.bimo.bimo.pojo.User;
import com.bimo.bimo.pojo.UserAndToken;
import com.bimo.bimo.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private UserServiceImpl userService;

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public MyResponse Register(String username, String password) {
        if (userService.existsByUsername(username)) {
            return new MyResponse("当前用户已存在，无需重复注册！", HttpStatus.ALREADY_REPORTED);
        }
        User user = userService.saveUser(new User(username, password));
        return new MyResponse(new UserAndToken(user, JwtToken.createJWT(user)), HttpStatus.CREATED);
    }
}
