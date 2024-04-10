package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SaveContactTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        clickOnLoginLink();
        fillLoginForm(new User().setEmail("akuna@mata.ta")
                .setPassword("Africa2024!"));
        clickOnLoginButton();
    }

    @Test
    public void saveAccountPositiveTest() {
        clickOnEmailAccount();
        clickOnSaveButton();
    }
}

