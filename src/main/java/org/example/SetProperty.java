package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;

public class SetProperty {
    private WebDriver driver;

    public SetProperty() {
    }

    public SetProperty(WebDriver driver) {
        this.driver = driver;
    }
@BeforeMethod
    public void setUpHomePage() {

        System.setProperty("webdriver.chrome.driver", "/home/azilen/QA/automation/chromedriver-linux64/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");


    }

}
