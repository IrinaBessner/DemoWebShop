package com.demowebshop.tests;

import com.demowebshop.models.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SaveContactTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogOutLink();
        }
    }

    @Test
    public void saveAccountPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail("akuna@mata.ta")
                .setPassword("Africa2024!"));
        app.getUser().clickOnLoginButton();
        app.getUser().clickOnEmailAccount();
        app.getUser().clickOnSaveButton();
    }
}

