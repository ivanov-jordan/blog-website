package com.blog.website.repository;

import org.springframework.data.repository.CrudRepository;

import com.blog.website.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User findByEmail(String email);

}
