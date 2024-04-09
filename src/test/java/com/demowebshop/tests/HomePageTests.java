package com.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{

    @Test
    public void isDemoWebShopPresentTest() {
        Assert.assertTrue(isDemoWebShopPresentPresent());
    }

}
