package com.blog.website.utils;

import org.junit.Assert;
import org.junit.Test;

public class PasswordUtilsTest {

    @Test
    public void testPasswords() {
        String test_passwd = "abcdefghijklmnopqrstuvwxyz";
        String test_hash = "$2a$06$.rCVZVOThsIa97pEDOxvGuRRgzG64bvtJ0938xuqzv18d3ZpQhstC";
        String computed_hash = PasswordUtils.hashPassword(test_passwd);

        Assert.assertTrue(PasswordUtils.checkPassword(test_passwd, test_hash));
        Assert.assertTrue(PasswordUtils.checkPassword(test_passwd, computed_hash));
    }

}
