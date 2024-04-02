package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddToCart {

    private WebDriver driver;

    @BeforeClass
    public void setUpHomePage() {

        System.setProperty("webdriver.chrome.driver", "/home/azilen/QA/automation/chromedriver-linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        Login login = new Login(driver);
        login.usingValidUserAndPassword();
        WebElement addtocart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        addtocart.click();
    }
    @AfterClass
    public void distroy(){
        if (driver != null) {
            driver.quit();
        }
    }

    @Test(priority = 1)
    public void RemoveProductOnAddToCart() {
        try {
            Thread.sleep(2000);
            WebElement cancel = driver.findElement(By.xpath("//button[@id='continue-shopping']"));
            cancel.click();
            Thread.sleep(2000);
            WebElement addProduct = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
            addProduct.click();
            Thread.sleep(2000);
            WebElement addtocartAgain = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
            addtocartAgain.click();
            Thread.sleep(2000);
            WebElement clickToRemove = driver.findElement(By.id("remove-sauce-labs-backpack"));
            clickToRemove.click();
            Thread.sleep(2000);



        } catch (Exception e) {
            System.out.println("error Detect");
        }
    }

    @Test(priority = 1)
    public void ContinueAddToCart() {
        try {
            WebElement clickAddToCart = driver.findElement(By.xpath("`//a[@class='shopping_cart_link']`"));
            clickAddToCart.click();
            Thread.sleep(2000);
            WebElement checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
            checkout.click();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);

        } catch (Exception e) {
            System.out.println("error Detect");
        }
    }

    @Test(priority = 2)
    public void cancelToRedirectHomePage() {
        WebElement cancel = driver.findElement(By.xpath("//button[@id='continue-shopping']"));
        cancel.click();
        WebElement HomePage = driver.findElement(By.xpath("//span[@class='title']"));
        Assert.assertEquals("Products", HomePage.getText());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
