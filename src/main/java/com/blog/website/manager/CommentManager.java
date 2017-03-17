package com.blog.website.manager;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blog.website.model.Article;
import com.blog.website.model.Comment;
import com.blog.website.model.User;
import com.blog.website.repository.CommentRepository;

@Component
public class CommentManager {

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getComments(long articleId) {
        return commentRepository.findAllByArticle_IdOrderByPublishedDesc(articleId);
    }

    public void submitComment(Comment comment, Article article, User user) {
        comment.setArticle(article);
        comment.setUser(user);
        commentRepository.save(comment);
    }

    public void deleteComment(long commentId) {
        commentRepository.delete(commentId);
    }

}
