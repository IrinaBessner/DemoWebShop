package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getHomePage().isDemoWebShopComponentPresent()) {
            app.getHomePage().clickOnDemoWebShopLogo();
        }
    }

    @Test
    public void isDemoWebShopPresentTest() {
        Assert.assertTrue(app.getHomePage().isDemoWebShopComponentPresent());
    }

}
