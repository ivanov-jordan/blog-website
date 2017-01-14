package com.blog.website.manager;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blog.website.model.Article;
import com.blog.website.model.User;
import com.blog.website.repository.ArticleRepository;

@Component
public class ArticleManager {

    @Autowired
    private ArticleRepository articleRepository;

    public Article getArticle(long id) {
        return articleRepository.findOne(id);
    }

    public List<Article> getLastArticles(int num) {
        return articleRepository.findAllByOrderByPublishedDesc();
    }

    public List<Article> getArticlesByCategory(long categoryId) {
        return articleRepository.findAllByCategories_IdOrderByPublishedDesc(categoryId);
    }

    public void submitArticle(Article article, User author) {
        article.setAuthor(author);
        article.setPublished(new Date());
        articleRepository.save(article);
    }

    public void deleteArticle(long articleId) {
        articleRepository.delete(articleId);
    }

}
