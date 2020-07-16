package com.bimo.bimo.controller;


import com.bimo.bimo.dao.Resultful;
import com.bimo.bimo.pojo.User;
import com.bimo.bimo.service.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/attention")
public class AttentionController {

    private UserServiceImpl userService;

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public Set<User> getMyAttention(String user_id) {
        User user = userService.getUserById(user_id);
        return user.getLover();
    }

    @PostMapping
    public Resultful saveAttention(String user_id, String author_id) {
        if (user_id.equals(author_id)) {
            return new Resultful(200, "自己关注自己？");
        }
        User user = userService.getUserById(user_id);
        User author = userService.getUserById(author_id);
        user.getLover().add(author);
        userService.saveUser(user);
        return new Resultful(200, "关注成功！");
    }

    @DeleteMapping
    public Resultful deleteAttention(String user_id, String author_id) {
        userService.deleteAttentionById(user_id, author_id);
        return new Resultful(200, "删除成功！");
    }
}

