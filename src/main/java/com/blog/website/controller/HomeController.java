package com.blog.website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.blog.website.manager.ArticleManager;

@Controller
@RequestMapping(HomeController.URI)
public class HomeController {

    public static final String URI = "/";

    @Autowired
    private ArticleManager articleManager;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView mav = new ModelAndView("home");
        mav.addObject("articles", articleManager.getLastArticles(10));
        return mav;
    }

}
