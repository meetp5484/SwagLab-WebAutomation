package org.example;

import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Login {
    private WebDriver driver;

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    public Login() {
    }

    @BeforeClass
    public void setUpLogin() {
        System.setProperty("webdriver.chrome.driver", "/home/azilen/QA/automation/chromedriver-linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

    }



    @Test(priority = 2)
    public void usingNullUserAndPassword() {
        driver.navigate().back();
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.click();
        username.sendKeys("");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.clear();
        password.sendKeys("");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement submit = driver.findElement(By.id("login-button"));
        submit.click();

        // Verify error message
        String errorGenerate = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals("Epic sadface: Username is required", errorGenerate);


    }


    @Test(priority = 1)
    public void usingInvalidUserAndValidPassword() {
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.clear();
        username.sendKeys("abc@123");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.clear();
        password.sendKeys("secret_sauce");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement submit = driver.findElement(By.id("login-button"));
        submit.click();
        String errorGenerate = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", errorGenerate);

    }

    @Test(priority = 2)
    public void usingvalidUserAndInvalidPassword() {
        try {
            WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
            username.clear();
            username.sendKeys("standard_user");
            WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
            password.clear();
            password.sendKeys("computer");

            Thread.sleep(2000);

            WebElement submit = driver.findElement(By.id("login-button"));
            submit.click();
            String errorGenerate = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
            Assert.assertEquals("Epic sadface: Username and password do not match any user in this service", errorGenerate);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 1)
    public void usingValidUserAndPassword() {
        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        username.clear();
        username.sendKeys("problem_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.clear();
        password.sendKeys("secret_sauce");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement submit = driver.findElement(By.id("login-button"));
        submit.click();
        String result = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", result);
    }
    @AfterClass
    public void distroy() {
        if (driver != null) {
            driver.quit();
        }
    }


}
