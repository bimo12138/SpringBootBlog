package com.bimo.bimo.controller;

import com.bimo.bimo.dao.Resultful;
import com.bimo.bimo.pojo.User;
import com.bimo.bimo.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserManagerController {

    private UserServiceImpl userService;

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public User getUserByUsername(String username) {
        return userService.getUserByUsername(username);
    }

    @PostMapping
    public User saveUser(String username, String password) {
        return userService.saveUser(new User(username, password));
    }

    @PutMapping
    public Resultful updateUser(String username, int sex, int age, String id) {
        if (userService.updateUserById(username, sex, age, id) >= 1) {
            return new Resultful(200, username + "的信息修改成功！");
        }
        return new Resultful(200, "信息删除失败！");
    }

    @DeleteMapping
    public Resultful deleteUser(String id) {
        if (userService.deleteUserById(id) >= 1) {
            return new Resultful(200, id + "信息删除成功！");
        }
        return new Resultful(200, "删除失败！");
    }
}

