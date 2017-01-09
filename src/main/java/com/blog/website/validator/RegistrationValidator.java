package com.blog.website.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.blog.website.manager.UserManager;
import com.blog.website.model.RegisterForm;
import com.blog.website.model.User;

@Component
public class RegistrationValidator {

    @Autowired
    private UserManager userManager;

    public void validateForm(RegisterForm registerForm, Errors errors) {
        // validate username
        User user = userManager.getUser(registerForm.getUsername());
        if (user != null) {
            errors.rejectValue("username", "register.username.taken");
        }

        // validate first and last name
        if (registerForm.getFirstname().trim().isEmpty()) {
            errors.rejectValue("firstname", "register.firstname.empty");
        }
        if (registerForm.getLastname().trim().isEmpty()) {
            errors.rejectValue("lastname", "register.lastname.empty");
        }

        // validate password
        if (!registerForm.getPassword().equals(registerForm.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "register.password.mismatch");
        }
    }

}
