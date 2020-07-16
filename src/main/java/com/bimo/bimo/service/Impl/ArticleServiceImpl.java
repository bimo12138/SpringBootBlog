package com.bimo.bimo.service.Impl;

import com.bimo.bimo.dao.ArticleDao;
import com.bimo.bimo.pojo.Article;
import com.bimo.bimo.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArticleServiceImpl implements ArticleService {

    private ArticleDao articleDao;

    @Autowired
    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Override
    public Article getArticleById(String id) {
        return articleDao.getArticleById(id);
    }

    @Override
    public Article saveArticle(Article article) {
        return articleDao.saveAndFlush(article);
    }
}
