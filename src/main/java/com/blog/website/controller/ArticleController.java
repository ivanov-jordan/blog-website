package com.blog.website.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.blog.website.manager.ArticleManager;
import com.blog.website.manager.CommentManager;
import com.blog.website.manager.SessionManager;
import com.blog.website.model.Article;
import com.blog.website.model.Category;
import com.blog.website.model.Comment;
import com.blog.website.model.User;

@Controller
@RequestMapping(ArticleController.URI)
public class ArticleController {

    public static final String URI = "article";
    public static final String URI_ARTICLE = "/{articleId}";
    public static final String URI_EDIT = URI_ARTICLE + "/edit";
    public static final String URI_COMMENT = URI_ARTICLE + "/comment";

    @Autowired
    private CategoryEditor categoryEditor;

    @Autowired
    private ArticleManager articleManager;

    @Autowired
    private CommentManager commentManager;

    @Autowired
    private SessionManager sessionManager;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Category.class, categoryEditor);
    }

    @RequestMapping(value = URI_ARTICLE, method = RequestMethod.GET)
    public ModelAndView articleShow(@PathVariable long articleId) {
        Article article = articleManager.getArticle(articleId);
        List<Comment> comments = commentManager.getComments(articleId);

        ModelAndView mav = new ModelAndView("article");
        mav.addObject("article", article);
        mav.addObject("comments", comments);
        mav.addObject("commentForm", new Comment());
        return mav;
    }

    @RequestMapping(value = URI_EDIT, method = RequestMethod.GET)
    public ModelAndView articleEdit(@PathVariable long articleId, HttpServletRequest request) {
        Article article = articleManager.getArticle(articleId);
        if (articleId <= 0) {
            article = new Article();
        }

        ModelAndView mav = new ModelAndView("article_edit");
        mav.addObject("articleForm", article);
        return mav;
    }

    @RequestMapping(value = URI_EDIT, method = RequestMethod.POST)
    public ModelAndView articleSubmit(@PathVariable long articleId, @ModelAttribute("articleForm") Article article,
            HttpServletRequest request) {
        User user = sessionManager.get(request);

        ModelAndView mav = new ModelAndView("article_edit");

        // TODO validate article form
        articleManager.submitArticle(article, user);
        mav.setView(new RedirectView("/" + URI + "/" + article.getId(), true, true, false));

        return mav;
    }

    @RequestMapping(value = URI_COMMENT, method = RequestMethod.POST)
    public ModelAndView commentSubmit(@PathVariable long articleId, @ModelAttribute("commentForm") Comment comment,
            BindingResult result, HttpServletRequest request) {
        Article article = articleManager.getArticle(articleId);
        List<Comment> comments = commentManager.getComments(articleId);

        ModelAndView mav = new ModelAndView("article");
        mav.addObject("article", article);
        mav.addObject("comments", comments);

        User user = sessionManager.get(request);

        if (comment == null || StringUtils.isEmpty(comment.getComment())) {
            result.reject("comment.empty");
        } else if (user == null) {
            result.reject("comment.anonymous");
        } else {
            commentManager.submitComment(comment, article, user);
            mav.setView(new RedirectView("/" + URI + "/" + article.getId(), true, true, false));
        }

        return mav;
    }

}
