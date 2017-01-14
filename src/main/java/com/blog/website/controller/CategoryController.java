package com.blog.website.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import com.blog.website.manager.ArticleManager;
import com.blog.website.manager.CategoryManager;
import com.blog.website.model.Category;

@Controller
@RequestMapping(CategoryController.URI)
public class CategoryController {

    public static final String URI = "category";
    public static final String URI_CATEGORY = "/{categoryId}";
    public static final String URI_EDIT = URI_CATEGORY + "/edit";
    public static final String URI_DELETE = URI_CATEGORY + "/delete";

    @Autowired
    private ArticleManager articleManager;

    @Autowired
    private CategoryManager categoryManager;

    @RequestMapping(value = URI_CATEGORY, method = RequestMethod.GET)
    public ModelAndView showCategory(@PathVariable long categoryId) {
        ModelAndView mav = new ModelAndView("category");
        mav.addObject("selectedCategory", categoryId);
        mav.addObject("articles", articleManager.getArticlesByCategory(categoryId));
        return mav;
    }

    @RequestMapping(value = URI_EDIT, method = RequestMethod.GET)
    public ModelAndView editCategory(@PathVariable long categoryId) {
        Category category = null;
        if (categoryId <= 0) {
            category = new Category();
        } else {
            category = categoryManager.getCategory(categoryId);
        }

        ModelAndView mav = new ModelAndView("category_edit");
        mav.addObject("categoryForm", category);
        return mav;
    }

    @RequestMapping(value = URI_EDIT, method = RequestMethod.POST)
    public ModelAndView submitCategory(@PathVariable long categoryId, @ModelAttribute("categoryForm") Category category,
            HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("category_edit");

        // TODO validate category name
        categoryManager.saveCategory(category);
        mav.setView(new RedirectView("/" + URI + "/" + category.getId(), true, true, false));
        return mav;
    }

    @RequestMapping(value = URI_DELETE, method = RequestMethod.POST)
    public View deleteCategory(@PathVariable long categoryId, HttpServletRequest request) {
        categoryManager.deleteCategory(categoryId);
        return new RedirectView(HomeController.URI, true, true, false);
    }

}
