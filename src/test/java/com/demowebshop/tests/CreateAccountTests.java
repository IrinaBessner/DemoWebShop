package com.demowebshop.tests;

import com.demowebshop.models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase {
    @BeforeMethod
    public void ensurePrecondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnLogOutLink();
        }
    }

    @Test
    public void createNewAccountPositiveTest() {
//        Random random = new Random();
//        int i = random.nextInt(1000) + 1000;
//        type(By.name("email"), "akuna" + i + "@ma.de");
//        type(By.id("Email"), "akuna@ma.de");

        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm(new User().setEmail("akuna@mata.ta")
                .setPassword("Africa2024!")
                .setPassword("Africa2024!")
                .setFirstname("Akuna")
                .setSecondname("Matata"));
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isLoginOnPresent());
    }

    @Test
    public void createNewAccountWithExistedEmailNegativeTest() {
        app.getUser().clickOnRegisterLink();
        app.getUser().fillRegisterForm(new User()
                .setEmail("akuna@mata.ta")
                .setPassword("Africa2024!")
                .setFirstname("Akuna")
                .setSecondname("Matata"));
        app.getUser().clickOnRegisterButton();
        Assert.assertTrue(app.getUser().isElementPresent(By.xpath("//li[.='The specified email already exists']")));
        app.getUser().ifEmailAlreadyExist();
    }

}



