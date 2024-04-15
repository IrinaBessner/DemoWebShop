package com.demowebshop.fw;

import com.demowebshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnRegisterButton() {
        click(By.id("register-button"));
    }

    public void fillRegisterForm(User user) {
        type(By.id("FirstName"), user.getFirstname());
        type(By.id("LastName"), user.getSecondname());
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
        type(By.id("ConfirmPassword"), user.getPassword());
    }

    public void clickOnRegisterLink() {
        click(By.cssSelector("[href='/register']"));
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("[value='Log in']"));
    }

    public void fillLoginForm(User user) {
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
    }

    public void clickOnSaveButton() {
        click(By.cssSelector("[value='Save']"));
    }

    public boolean isLogOutLinkPresent() {
        return isElementPresent((By.cssSelector("[href='/logout']")));
    }

    public void clickOnLogOutLink() {
        click(By.cssSelector("[href='/logout']"));
    }

    public boolean isLoginLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }

    public void ifEmailAlreadyExist() {
        if ((isElementPresent(By.xpath("//li[.='The specified email already exists']")))) {
            clickOnLoginLink();
        }
    }

    public void clickOnLoginLink() { click(By.cssSelector("[href='/login']")); }

    public void clickOnEmailAccount() {
        click((By.xpath("//a[text()='akuna@mata.ta']")));
    }
}


