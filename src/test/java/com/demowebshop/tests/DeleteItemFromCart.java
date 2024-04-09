package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteItemFromCart extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        fillLoginForm();
        clickOnLoginButton();

        clickOnItempicture();
        clickOnAddTocart();
        clickOnShoppingCartLink();
    }

    @Test
    public void DeleteItemFromCartPositiveTest() {
        int sizeBefore = sizeOfItems();
        removeItem();
        pause(1000);

        int sizeAfter = sizeOfItems();
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }
}
