package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteItemFromCart extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isLoginLinkPresent()){
            clickOnLogOutLink();
        }
        clickOnLoginLink();
        fillLoginForm(new User().setEmail("akuna@mata.ta")
                .setPassword("Africa2024!"));

        clickOnLoginButton();

        clickOnItemPicture();
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
