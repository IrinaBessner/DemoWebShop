package com.demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageHelper extends BaseHelper{
    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    public boolean isDemoWebShopComponentPresent() {
        return isElementPresent(By.cssSelector("[href='https://academy.tricentis.com']"));
    }

    public void clickOnDemoWebShopLogo() {
        click(By.xpath("//img[@title='']"));
    }
}
