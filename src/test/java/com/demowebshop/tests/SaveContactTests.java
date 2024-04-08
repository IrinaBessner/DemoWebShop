package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class SaveContactTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition() {
        click(By.cssSelector("[href='/login']"));
        type(By.id("Email"), "akuna@mata.ta");
        type(By.id("Password"), "Africa2024!");
        click(By.cssSelector("[value='Log in']"));
    }

    @Test
    public void addContactsPositiveTest(){
        //click(By.xpath("//a[@href='/customer/info' and @class='account']"));
        click((By.xpath("//a[text()='akuna@mata.ta']")));
        type(By.id("FirstName"), "Akuna");
        type(By.id("LastName"), "Matata");
        type(By.id("Email"), "akuna@mata.ta");
        click(By.cssSelector("[value='Save']"));

    }
}
