package com.blog.website.model;

import com.blog.website.utils.PasswordUtils;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class RegisterForm extends User {

    private String confirmPassword;

    public User toEntity() {
        User user = new User();
        user.setUsername(getUsername());
        user.setFirstname(getFirstname());
        user.setLastname(getLastname());
        user.setEmail(getEmail());
        user.setPassword(PasswordUtils.hashPassword(getPassword()));
        user.setEditor(false);
        return user;
    }

}
