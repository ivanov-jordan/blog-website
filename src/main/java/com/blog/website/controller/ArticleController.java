package com.blog.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(ArticleController.URI)
public class ArticleController {

    public static final String URI = "article";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String test() {
        return "test";
    }

}
