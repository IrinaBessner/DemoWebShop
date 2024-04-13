package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if (!isLoginLinkPresent()){
            clickOnLogOutLink();
        }
    }
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

    public boolean isWarningPresentLogin() {
        return isElementPresent(By.xpath("//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]"));
    }
}


