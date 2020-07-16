package com.bimo.bimo.dao;

import com.bimo.bimo.pojo.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ArticleDao extends JpaRepository<Article, String> {

    public Article getArticleById(String id);

}
