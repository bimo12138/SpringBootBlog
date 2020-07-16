package com.bimo.bimo.controller;

import com.bimo.bimo.dao.Resultful;
import com.bimo.bimo.pojo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {
    @RequestMapping("/link")
    public Resultful LinkTest() {
        return new Resultful(200, "欢迎登陆首页");
    }

    @PostMapping
    public ResponseEntity<User> testUserEntity(Integer id) {
        if (id > 10) {
            return new ResponseEntity<User>(new User(id.toString()), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }
}
