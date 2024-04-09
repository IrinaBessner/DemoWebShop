package com.demowebshop.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SaveContactTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        fillLoginForm();
        clickOnLoginButton();
    }

    @Test
    public void saveAccountPositiveTest(String secondname, String email, String firstname){
        clickOnEmailAccount();
        fillLoginFormForSave(secondname, email, firstname);
        clickOnSaveButton();
    }
}
