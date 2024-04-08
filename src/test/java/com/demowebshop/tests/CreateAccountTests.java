package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Random;

public class CreateAccountTests extends TestBase {

    @Test(enabled = false)
    public void createNewAccountPositiveTest() {
//        Random random = new Random();
//        int i = random.nextInt(1000) + 1000;
//        type(By.name("email"), "akuna" + i + "@ma.de");
//        type(By.id("Email"), "akuna@ma.de");

        // click on Register Link
        click(By.cssSelector("[href='/register']"));

        type(By.id("FirstName"), "Akuna");

        type(By.id("LastName"), "Matata");

        type(By.id("Email"), "akuna@mata.ta");

        type(By.id("Password"), "Africa2024!");

        type(By.id("ConfirmPassword"), "Africa2024!");

        // click on Register button
        click(By.id("register-button"));
        // assert Sign Out button is present
        //Assert.assertTrue(isElementPresent(By.cssSelector("[href='/logout']")));
        Assert.assertTrue(isElementPresent((By.xpath("//a[text()='akuna@mata.ta']"))));
    }

    @Test
    public void createNewAccountWithExistedEmailNegativeTest() {
        // click on Register Link
        click(By.cssSelector("[href='/register']"));

        type(By.id("FirstName"), "Akuna");

        type(By.id("LastName"), "Matata");

        type(By.id("Email"), "akuna@mata.ta");

        type(By.id("Password"), "Africa2024!");

        type(By.id("ConfirmPassword"), "Africa2024!");

        // click on Register button
        click(By.id("register-button"));
        Assert.assertTrue(isElementPresent(By.xpath("//li[.='The specified email already exists']")));
    }
}



