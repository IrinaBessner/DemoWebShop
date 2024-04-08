package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void isDemoWebShopPresentTest() {
        Assert.assertTrue(isDemoWebShopPresentPresent());
    }

    public boolean isDemoWebShopPresentPresent() {
        return isElementPresent(By.cssSelector("title"));
    }
}
