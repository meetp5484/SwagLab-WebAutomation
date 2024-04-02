package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class ParentToChild {

    public static void FirstToSecondScreed(WebDriver driver) {

        System.out.println("time loaded");
        driver.get("https://www.salesforce.com/in/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//div[@class='cta_container flex flex--right ctas__2']//pbc-button[@class='cta_button__wrapper']//a[@class='cta_button'][contains(text(),'Start free trial')]")).click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        Set<String> allWindowhandels = driver.getWindowHandles();
        System.out.println(allWindowhandels);

        Iterator<String> iterator = allWindowhandels.iterator();
        String parentwebsite = iterator.next();
        String childwebsite = iterator.next();

        driver.switchTo().window(childwebsite);


        WebElement firstname = driver.findElement(By.name("UserFirstName"));
        firstname.sendKeys("Meet");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement lastname = driver.findElement(By.name("UserLastName"));
        lastname.sendKeys("Patel");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }




    }
}
