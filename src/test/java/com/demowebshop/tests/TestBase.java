package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.List;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        driver.quit();
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text != null) {
            click(locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public boolean isSignOnPresent() {
        return isElementPresent((By.xpath("//a[text()='akuna@mata.ta']")));
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

    public void fillLoginForm(User user) {
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("[value='Log in']"));
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }


    public void clickOnShoppingCartLink() {
        click(By.linkText("Shopping cart"));
    }

    public void clickOnAddTocart() {
        click(By.id("add-to-cart-button-31"));
    }

    public void clickOnItempicture() {
        click(By.cssSelector(".item-box:nth-child(3) .picture"));
    }

    public boolean isItemAddedToCart(String text) {
        List<WebElement> items = driver.findElements(By.cssSelector("tr td:nth-child(3) a"));
        for (WebElement element : items) {
            if (element.getText().contains(text))
                return true;
        }
        return false;
    }

    public void clickOnSaveButton() {
        click(By.cssSelector("[value='Save']"));
    }

    public void clickOnEmailAccount() {
        click((By.xpath("//a[text()='akuna@mata.ta']")));
    }

    public void fillLoginFormForSave(String secondname, String email, String firstname) {
        type(By.id("FirstName"), firstname);
        type(By.id("LastName"), secondname);

        type(By.id("Email"), email);
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

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean isDemoWebShopPresentPresent() {
        return isElementPresent(By.cssSelector("title"));
    }

    protected boolean isWarningPresentLogin() {
        return isElementPresent(By.xpath("//span[contains(text(),'Login was unsuccessful. Please correct the errors ')]"));
    }
}
