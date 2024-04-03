package org.example;

import org.checkerframework.checker.units.qual.A;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage() {
    }

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

    }


    @Test(priority = 1)
    public void GoInsideAndSelect() {

        WebElement usingTextOpen = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]"));
        usingTextOpen.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        WebElement addToCart = driver.findElement(By.xpath("//button[@id='add-to-cart']"));
        addToCart.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (Objects.equals(addToCart.getText(), "Add to cart")) {

            System.out.println("HomePage :AddTocart button not working ");
            driver.findElement(By.id("back-to-products")).click();
        } else {
            System.out.println("HomePage :AddTocart button working successfully");
            driver.findElement(By.id("back-to-products")).click();
        }
        WebElement addToCart2 = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        addToCart2.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement removeProduct = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removeProduct.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if (removeProduct.getText().equals("Remove")) {

            System.out.println("HomePage :product not remove");
            Assert.assertEquals("Add to cart", removeProduct.getText());
        } else {
            System.out.println("HomePage :product remove");
            Assert.assertEquals("Remove", removeProduct.getText());
        }
    }
    @Test
public void wrongProduct(){
            try {
                WebElement clickProductAndAdd = driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Backpack')]"));
                clickProductAndAdd.click();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                WebElement clickProductAndAddDetails = driver.findElement(By.xpath("//div[@class='inventory_details_name large_size']"));
                WebElement Addtocart = driver.findElement(By.xpath("//button[@id='add-to-cart']"));
                if(Objects.equals(clickProductAndAddDetails.getText(), clickProductAndAdd.getText())){
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    Addtocart.click();
                    Assert.assertEquals("Remove",Addtocart.getText() );
                }
                else {
                    Assert.assertEquals("Add to cart",Addtocart.getText());
                }
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

}

    @Test(priority = 1)
    public void usingImageClickInsideOption() {
        try {
            WebElement clickImginside = driver.findElement(By.xpath("//a[@id='item_4_img_link']//img[@class='inventory_item_img']"));
            clickImginside.click();
            Thread.sleep(2000);
            WebElement addToCartInside = driver.findElement(By.xpath("//button[@id='add-to-cart']"));
            if (Objects.equals(addToCartInside.getText(), "Add to cart")) {
                addToCartInside.click();
                Thread.sleep(2000);
            } else {
                System.out.println("already clicked");
            }
            driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
            System.out.println("You Standing home page ");

            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
//        WebElement clickImginside = driver.findElement(By.xpath("//a[@id='item_4_img_link']//img[@class='inventory_item_img']"));
//            clickImginside.click();
//            WebElement addToCartInside = driver.findElement(By.xpath("//button[@id='add-to-cart']"));
//            if (Objects.equals(addToCartInside.getText(), "Add to cart")) {
//                addToCartInside.click();
//            } else {
//                System.out.println("already clicked");
//            }
//            driver.findElement(By.xpath("//button[@id='back-to-products']")).click();
//            System.out.println("You Standing home page ");
        }





    @Test(priority = 3)
    public void about() {
        try {
            WebElement navopen = driver.findElement(By.id("react-burger-menu-btn"));
            navopen.click();
            Thread.sleep(2000);
            WebElement aboutPage = driver.findElement(By.cssSelector("#about_sidebar_link"));
            aboutPage.click();
            Thread.sleep(2000);
            driver.navigate().back();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 4)
    public void Logout() {
        try {
            WebElement navopen = driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']"));
            navopen.click();
            Thread.sleep(2000);
            WebElement closeUser = driver.findElement(By.id("logout_sidebar_link"));
            closeUser.click();
Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 3)
    public void openTwitter() {


        try {
            WebElement twiter = driver.findElement(By.xpath("//a[contains(text(),'Twitter')]"));
            twiter.click();
            Thread.sleep(2000);
            Set<String> currentWndow = driver.getWindowHandles();
            Iterator<String> iterator = currentWndow.iterator();
            String thisPage = iterator.next();
            String nextPage = iterator.next();
            Thread.sleep(2000);
            driver.switchTo().window(thisPage);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 3)
    public void openFacebook() {
        try {
            WebElement twiter = driver.findElement(By.xpath("//a[contains(text(),'Facebook')]"));
            twiter.click();
            Thread.sleep(2000);
            Set<String> currentWndow = driver.getWindowHandles();
            Iterator<String> iterator = currentWndow.iterator();
            String thisPage = iterator.next();
            String nextPage = iterator.next();
            driver.switchTo().window(thisPage);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test(priority = 3)
    public void openLinkedIn() {
        try {
            WebElement twiter = driver.findElement(By.xpath("//a[contains(text(),'LinkedIn')]"));
            twiter.click();
            Thread.sleep(2000);
            Set<String> currentWndow = driver.getWindowHandles();
            Iterator<String> iterator = currentWndow.iterator();
            String thisPage = iterator.next();
            String nextPage = iterator.next();
            Thread.sleep(2000);
            driver.switchTo().window(thisPage);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    @AfterMethod
    public void distroy(){
        if (driver != null) {
            driver.quit();
        }
    }
}

