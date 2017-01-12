package com.blog.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.blog.website.manager.ArticleManager;

@Controller
@RequestMapping(CategoryController.URI)
public class CategoryController {

    public static final String URI = "category";
    public static final String URI_CATEGORY = "/{categoryId}";

    @Autowired
    private ArticleManager articleManager;

    @RequestMapping(value = URI_CATEGORY, method = RequestMethod.GET)
    public ModelAndView showArticles(@PathVariable long categoryId) {
        ModelAndView mav = new ModelAndView("category");
        mav.addObject("selectedCategory", categoryId);
        mav.addObject("articles", articleManager.getArticlesByCategory(categoryId));
        return mav;
    }

}
