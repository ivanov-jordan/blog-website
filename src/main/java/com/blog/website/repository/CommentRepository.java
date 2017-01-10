package com.blog.website.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.blog.website.model.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> {

    List<Comment> findAllByArticle_IdOrderByPublishedDesc(Long articleId);

}
