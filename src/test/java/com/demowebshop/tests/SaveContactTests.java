package com.demowebshop.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SaveContactTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()){
            clickOnLogOutLink();
        }
    }

    @Test
    public void saveAccountPositiveTest() {
        clickOnLoginLink();
        fillLoginForm(new User().setEmail("akuna@mata.ta")
                .setPassword("Africa2024!"));
        clickOnLoginButton();
        clickOnEmailAccount();
        clickOnSaveButton();
    }
}

