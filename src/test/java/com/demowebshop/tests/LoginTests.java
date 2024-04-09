package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginPositiveTest() {
        clickOnLoginLink();
        fillLoginForm(new User().setEmail("akuna@mata.ta")
                .setPassword("Africa2024!"));

        clickOnLoginButton();
        Assert.assertTrue(isSignOnPresent());
    }

    @Test
    public void loginNegativeTestWithoutEmail() {
        clickOnLoginLink();
        fillLoginForm(new User().setPassword("Africa2024!"));
        clickOnLoginButton();
        Assert.assertTrue(isWarningPresentLogin());
    }

}


