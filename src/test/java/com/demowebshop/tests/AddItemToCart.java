package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCart extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        fillLoginForm();
        clickOnLoginButton();
    }

    @Test
    public void addItemToCardPositiveTest() {
        // Выбрать товар  и добавить его в корзину
        clickOnItempicture();
        clickOnAddTocart();
        clickOnShoppingCartLink();
        // Проверить, что товар успешно добавлен в корзину
        Assert.assertTrue(isItemAddedToCart("14.1-inch Laptop"));
    }

    @AfterMethod
    public void postCondition(){
        removeItem();
    }
}

