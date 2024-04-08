package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @Test
    public void loginPositiveTest(){
        click(By.cssSelector("[href='/login']"));
        type(By.id("Email"), "akuna@mata.ta");
        type(By.id("Password"), "Africa2024!");
        //click on Log in button
        click(By.cssSelector("[value='Log in']"));
        //Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")));
        Assert.assertTrue(isElementPresent((By.xpath("//a[text()='akuna@mata.ta']"))));

    }

}
