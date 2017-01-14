package com.blog.website.manager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.blog.website.model.Category;
import com.blog.website.repository.CategoryRepository;

@Component
public class CategoryManager {

    public static final String MODEL_ATTRIBUTE_CATEGORIES_LIST = "categoriesList";

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();
        categoryRepository.findAll().forEach(categories::add);
        return categories;
    }

    public Category getCategory(long categoryId) {
        return categoryRepository.findOne(categoryId);
    }

    public Category saveCategory(Category category) {
        return categoryRepository.save(category);
    }

    public void deleteCategory(long categoryId) {
        categoryRepository.delete(categoryId);
    }

}
