package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutProcess {
    private WebDriver driver;



    @BeforeMethod
public void setUpCheckProcess(){
        System.setProperty("webdriver.chrome.driver", "/home/azilen/QA/automation/chromedriver-linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        Login login = new Login(driver);
        login.usingValidUserAndPassword();
        WebElement shopingLink = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        shopingLink.click();
}

    @Test(priority = 2)
    public void VerifyWithNullDetails() {
        try {
            WebElement checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
            checkout.click();
            Thread.sleep(2000);
            WebElement firstname = driver.findElement(By.xpath("//input[@id='first-name']"));
            firstname.sendKeys("");
            Thread.sleep(2000);
            WebElement lastname = driver.findElement(By.xpath("//input[@id='last-name']"));
            lastname.sendKeys("");
            Thread.sleep(2000);
            WebElement postalcode = driver.findElement(By.xpath("//input[@id='postal-code']"));
            postalcode.sendKeys("");
            Thread.sleep(2000);
            driver.findElement(By.id("continue")).click();
            Thread.sleep(2000);
            Assert.assertEquals("https://www.saucedemo.com/checkout-step-one.html", driver.getCurrentUrl());

        } catch (Exception e) {
            System.out.println("error detect");
        }
    }

    @Test(priority = 2)
    public void VerifyWithInvalidDetails() {
        try {

            WebElement checkout = driver.findElement(By.xpath("//button[@id='checkout']"));
            checkout.click();
            Thread.sleep(2000);
            WebElement firstname = driver.findElement(By.xpath("//input[@id='first-name']"));
            Thread.sleep(2000);
            firstname.clear();
            Thread.sleep(2000);
            firstname.sendKeys("3713uifas");
            WebElement lastname = driver.findElement(By.xpath("//input[@id='last-name']"));
            lastname.clear();
            Thread.sleep(2000);
            lastname.sendKeys("039qjefik");
            Thread.sleep(2000);
            WebElement postalcode = driver.findElement(By.xpath("//input[@id='postal-code']"));
            postalcode.clear();
            Thread.sleep(2000);
            postalcode.sendKeys("oqufq252");
            postalcode.getText();
Assert.assertEquals("", lastname.getText());
        } catch (Exception e) {
            System.out.println("Error Detect");
        }
    }

    @Test(priority = 2)
    public void VerifyWithValidDetails() {
        try {
            WebElement firstname = driver.findElement(By.xpath("//input[@id='first-name']"));
            firstname.clear();
            Thread.sleep(2000);
            firstname.sendKeys("Meet");
            Thread.sleep(2000);
            WebElement lastname = driver.findElement(By.xpath("//input[@id='last-name']"));
            lastname.clear();
            Thread.sleep(2000);
            lastname.sendKeys("Patel");
            Thread.sleep(2000);
            WebElement postalcode = driver.findElement(By.xpath("//input[@id='postal-code']"));
            postalcode.clear();
            Thread.sleep(2000);
            postalcode.sendKeys("380054");
            Thread.sleep(2000);

        } catch (Exception e) {
            System.out.println("Error Detect");
        }
    }
    @AfterMethod
    public void distroy(){
        if (driver != null) {
            driver.quit();
        }
    }
}
