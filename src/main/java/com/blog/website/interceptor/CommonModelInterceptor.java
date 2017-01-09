package com.blog.website.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.blog.website.manager.CategoryManager;
import com.blog.website.manager.SessionManager;

@Component
public class CommonModelInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private SessionManager sessionManager;

    @Autowired
    private CategoryManager categoryManager;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("categoriesList", categoryManager.getCategories());
        modelAndView.addObject("user", sessionManager.get(request));

    }

}
