package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SaveContactTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        fillLoginForm();
        clickOnLoginButton();
    }

    @Test
    public void saveAccountPositiveTest() {
        clickOnEmailAccount();
        clickOnSaveButton();
    }
}

