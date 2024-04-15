package com.demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ItemtHelper extends BaseHelper {


    public ItemtHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnShoppingCartLink() {
        click(By.linkText("Shopping cart"));
    }

    public void clickOnAddTocart() {
        click(By.id("add-to-cart-button-31"));
    }

    public void clickOnItemPicture() {
        click(By.cssSelector(".item-box:nth-child(3) .picture"));
    }

    public boolean isItemAddedToCart(String text) {
        List<WebElement> items = ApplicationManager.driver.findElements(By.cssSelector("tr td:nth-child(3) a"));
        for (WebElement element : items) {
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }

    public void removeItem() {
        click(By.name("removefromcart"));
        click(By.cssSelector("[value='Update shopping cart']"));

    }

    public int sizeOfItems() {
        if (isElementPresent(By.cssSelector("tr td:nth-child(3) a"))) {
            return driver.findElements(By.cssSelector("tr td:nth-child(3) a")).size();
        }
        return 0;
    }

}

