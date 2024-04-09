package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginPositiveTest(){
        fillLoginForm();
        //click on Log in button
        clickOnLoginButton();
        Assert.assertTrue(isSignOnPresent());
    }

}

