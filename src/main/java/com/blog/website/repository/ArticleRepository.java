package com.blog.website.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.blog.website.model.Article;

public interface ArticleRepository extends CrudRepository<Article, Long> {

    List<Article> findAllByOrderByPublishedDesc();

    List<Article> findByCategories_Id(Long categoryId);

}
