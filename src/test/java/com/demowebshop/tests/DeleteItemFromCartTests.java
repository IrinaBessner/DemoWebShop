package com.demowebshop.tests;

import com.demowebshop.data.UserData;
import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteItemFromCartTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogOutLink();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();

        app.getItem().clickOnItemPicture();
        app.getItem().clickOnAddTocart();
        app.getItem().clickOnShoppingCartLink();
    }

    @Test
    public void DeleteItemFromCartPositiveTest() {
        int sizeBefore = app.getItem().sizeOfItems();
        app.getItem().removeItem();
        app.getItem().pause(1000);

        int sizeAfter = app.getItem().sizeOfItems();
        Assert.assertEquals(sizeAfter, sizeBefore - 1);
    }
}
