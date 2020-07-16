package com.bimo.bimo.controller;


import com.bimo.bimo.pojo.Article;
import com.bimo.bimo.pojo.User;
import com.bimo.bimo.service.Impl.ArticleServiceImpl;
import com.bimo.bimo.service.Impl.UserServiceImpl;
import com.bimo.bimo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/article")
public class ArticleController {

    private ArticleServiceImpl articleService;
    private UserServiceImpl userService;

    @Autowired
    public void setArticleService(ArticleServiceImpl articleService) {
        this.articleService = articleService;
    }

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    public Article getArticleById(String id) {
        return articleService.getArticleById(id);
    }

    @PostMapping
    public Article saveArticle(String title, String content, String user_id) {
        User user = userService.getUserById(user_id);
        return articleService.saveArticle(new Article(title, content, user));
    }
}
