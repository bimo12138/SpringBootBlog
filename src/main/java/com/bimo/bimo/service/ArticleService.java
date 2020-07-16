package com.bimo.bimo.service;

import com.bimo.bimo.pojo.Article;

public interface ArticleService {
    public Article getArticleById(String id);
    public Article saveArticle(Article article);
}
