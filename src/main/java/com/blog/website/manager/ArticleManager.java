package com.blog.website.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blog.website.model.Article;
import com.blog.website.repository.ArticleRepository;

@Component
public class ArticleManager {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getLastArticles(int num) {
        return articleRepository.findAllByOrderByPublishedDesc();
    }

}
