package com.blog.website.controller;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blog.website.manager.CategoryManager;
import com.blog.website.model.Category;

@Component
public class CategoryEditor extends PropertyEditorSupport {

    @Autowired
    private CategoryManager categoryManager;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Category category = categoryManager.getCategory(Long.valueOf(text));
        this.setValue(category);
    }

}
