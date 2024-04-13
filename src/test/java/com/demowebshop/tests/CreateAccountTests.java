package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition(){
        if (!isLoginLinkPresent()){
            clickOnLogOutLink();
        }
    }

    @Test(enabled = false)
    public void createNewAccountPositiveTest() {
//        Random random = new Random();
//        int i = random.nextInt(1000) + 1000;
//        type(By.name("email"), "akuna" + i + "@ma.de");
//        type(By.id("Email"), "akuna@ma.de");

        clickOnRegisterLink();
        fillRegisterForm(new User().setEmail("akuna@mata.ta")
                .setPassword("Africa2024!")
                .setPassword("Africa2024!")
                .setFirstname("Akuna")
                .setSecondname("Matata"));
        clickOnRegisterButton();
        Assert.assertTrue(isSignOnPresent());
    }

    @Test
    public void createNewAccountWithExistedEmailNegativeTest() {
        clickOnRegisterLink();
        fillRegisterForm(new User()
                .setEmail("akuna@mata.ta")
                .setPassword("Africa2024!")
                .setFirstname("Akuna")
                .setSecondname("Matata"));
        clickOnRegisterButton();
        Assert.assertTrue(isElementPresent(By.xpath("//li[.='The specified email already exists']")));
        ifEmailAlreadyExist();
    }




}



