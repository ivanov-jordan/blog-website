package com.blog.website.repository;

import org.springframework.data.repository.CrudRepository;

import com.blog.website.model.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
