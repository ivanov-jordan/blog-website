package com.blog.website.utils;

import org.junit.Assert;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValidationUtilsTest {

    @Test
    public void testEmailValidation() {
        String[] emails = {"jordan@bsbulgaria.com", "j_ivanov@abv.bg", "jordan.ivanov@gmail.com",
                "test.test-90@gmail.com.com", "english123@queen.co.uk", "1@1", "no-at-sign.com", "invalid@domain",
                "@only.domain.name", "user-123@"};
        boolean[] results = {true, true, true, true, true, false, false, false, false, false};

        for (int i = 0; i < emails.length; i++) {
            Assert.assertTrue(ValidationUtils.isEmailValid(emails[i]) == results[i]);
        }
    }

    @Test
    public void testPasswordValidation() {
        String[] passwords = {"s1O#e", "noDigitsonly%", "123132314345", "okP4ssw&rd"};
        boolean[] results = {false, false, false, true};

        for (int i = 0; i < passwords.length; i++) {
            log.debug(ValidationUtils.isPasswordValid(passwords[i]) + "");
            Assert.assertTrue(ValidationUtils.isPasswordValid(passwords[i]) == results[i]);
        }
    }

}
