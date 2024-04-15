package com.demowebshop.tests;

import com.demowebshop.fw.ApplicationManager;
import com.demowebshop.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogOutLink();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail("akuna@mata.ta")
                .setPassword("Africa2024!"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addItemToCardPositiveTest() {
        // Выбрать товар  и добавить его в корзину
        app.getItem().clickOnItemPicture();
        app.getItem().clickOnAddTocart();
        app.getItem().clickOnShoppingCartLink();
        // Проверить, что товар успешно добавлен в корзину
        Assert.assertTrue(app.getItem().isItemAddedToCart("14.1-inch Laptop"));
    }
    public int sizeOfItems() {
        if (app.getUser().isElementPresent(By.cssSelector("tr td:nth-child(3) a"))) {
            return app.driver.findElements(By.cssSelector("tr td:nth-child(3) a")).size() ;
        }
        return 0;
    }

    @AfterMethod
    public void postCondition() {
        app.getItem().removeItem();
    }

}

