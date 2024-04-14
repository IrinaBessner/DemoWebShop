package com.demowebshop.tests;

import com.demowebshop.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogOutLink();
        }
    }
    @Test
    public void loginPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail("akuna@mata.ta")
                .setPassword("Africa2024!"));

        app.getUser().clickOnLoginButton();
        Assert.assertTrue(app.getUser().isLoginOnPresent());
    }

    @Test
    public void loginNegativeTestWithoutEmail() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setPassword("Africa2024!"));
        app.getUser().clickOnLoginButton();
        Assert.assertTrue(isWarningPresentLogin());
    }

    public boolean isWarningPresentLogin() {
        return app.getUser().isElementPresent(By.xpath("//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]"));
    }
}


