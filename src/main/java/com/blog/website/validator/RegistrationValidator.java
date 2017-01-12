package com.blog.website.validator;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

import com.blog.website.manager.UserManager;
import com.blog.website.model.RegisterForm;
import com.blog.website.model.User;
import com.blog.website.utils.ValidationUtils;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class RegistrationValidator {

    private static final String[] FIELDS = {"username", "firstname", "lastname", "email", "password",
            "confirmPassword"};

    @Autowired
    private UserManager userManager;

    public void validateForm(RegisterForm registerForm, Errors errors) {
        if (!validateEmptyFields(registerForm, errors)) {
            return;
        }

        // validate username
        User user = userManager.getUser(registerForm.getUsername());
        if (user != null) {
            errors.rejectValue("username", "register.username.taken");
        }

        // validate email address
        if (!ValidationUtils.isEmailValid(registerForm.getEmail())) {
            errors.rejectValue("email", "register.email.invalid");
        } else {
            user = userManager.getUserByEmail(registerForm.getEmail());
            if (user != null) {
                errors.rejectValue("email", "register.email.taken");
            }
        }

        // validate password
        if (!ValidationUtils.isPasswordValid(registerForm.getPassword())) {
            errors.rejectValue("password", "register.password.invalid");
        }

        // validate password confirmation
        if (!registerForm.getPassword().equals(registerForm.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "register.password.mismatch");
        }
    }

    private boolean validateEmptyFields(RegisterForm registerForm, Errors errors) {
        boolean passed = true;

        try {
            for (String field : FIELDS) {
                Method method = null;
                String methodName = "get" + StringUtils.capitalize(field);
                try {
                    method = User.class.getDeclaredMethod(methodName);
                } catch (NoSuchMethodException nsme) {
                    method = RegisterForm.class.getDeclaredMethod(methodName);
                }

                if (StringUtils.isEmpty((String) method.invoke(registerForm))) {
                    errors.rejectValue(field, "common.field.empty");
                    passed = false;
                }
            }
        } catch (Exception e) {
            log.error("Error while trying to validate for empty fields", e);
        }

        return passed;
    }

}
