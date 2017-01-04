package com.blog.website.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(HomeController.URI)
public class HomeController {

    public static final String URI = "/";

    @RequestMapping(method = RequestMethod.GET)
    public String home() {
        return "home";
    }

}
