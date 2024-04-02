package org.example;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.Set;

public class Main {
        public static void main(String[] args) {

                System.setProperty("webdriver.chrome.driver", "/home/azilen/QA/automation/chromedriver-linux64/chromedriver");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-allow-origins=*");
                WebDriver driver = new ChromeDriver(options);


//window handle
                driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");


                WebElement openNewWindow = driver.findElement(By.xpath("//button[@id='newWindowBtn']"));
                openNewWindow.click();
                Set<String> currentWndow = driver.getWindowHandles();
                Iterator<String> iterator = currentWndow.iterator();
                String thisPage = iterator.next();
                String nextPage = iterator.next();
                driver.switchTo().window(nextPage);

                driver.manage().window().maximize();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            driver.switchTo().window(thisPage);
                try {
                        Thread.sleep(2000);
                } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                }
                driver.manage().window().maximize();




                // Frame Switch
                // driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
                //
                // WebElement name = driver.findElement(By.id("name"));
                // name.sendKeys("Hello Meet");
                //
                // driver.switchTo().frame(driver.findElement(By.id("frm1")));
                // Select courseDD = new Select(driver.findElement(By.id("course")));
                // courseDD.selectByVisibleText("Java");
                //
                // driver.switchTo().defaultContent();
                //
                // name.clear();
                // name.sendKeys("good morning");
                // try {
                // Thread.sleep(5000);
                // } catch (InterruptedException e) {
                // throw new RuntimeException(e);
                // }

                driver.get("https://www.saucedemo.com/");
                driver.manage().window().maximize();
                // ParentToChild Class called
                // ParentToChild checkmethod = new ParentToChild();
                // checkmethod.FirstToSecondScreed(driver);

                // Login page
//                Login login = new Login();

//                login.usingNullUserAndPassword(driver);
//                login.usingInvalidUserAndValidPassword(driver);
//                login.usingvalidUserAndInvalidPassword(driver);
//                login.usingValidUserAndPassword(driver);
                // homepage
//                HomePage homePage = new HomePage();
//                HomePage.GoInsideAndSelect(driver);
                // HomePage.ZASelectAndAddProduct(driver);

                // Add tO Cart
//                AddToCart addToCart = new AddToCart();
                // AddToCart.RemoveProductOnAddToCart(driver);
//                AddToCart.ContinueAddToCart(driver);

                // Checkout Step By Step
//                CheckoutProcess checkout = new CheckoutProcess();
//                CheckoutProcess.VerifyWithNullDetails(driver);
//                CheckoutProcess.VerifyWithInvalidDetails(driver);
//                CheckoutProcess.VerifyWithValidDetails(driver);

        }

}

// home page
// WebElement addbutton =
// driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
// if (Objects.equals(addbutton.getText(), "Add to cart")) {
// addbutton.click();
// } else {
// System.out.println("Add to cart not working");
// }
// try {
// Thread.sleep(2000);
// } catch (InterruptedException e) {
// throw new RuntimeException(e);
// }
// WebElement sauceLabProduct =
// driver.findElement(By.xpath("//div[contains(text(),'Sauce Labs Bolt
// T-Shirt')]"));
// sauceLabProduct.click();
// try {
// Thread.sleep(2000);
// } catch (InterruptedException e) {
// throw new RuntimeException(e);
// }

// System.out.println(driver.getCurrentUrl());

// WebElement clickInsideButton = driver.findElement(By.id("add-to-cart"));
// if (Objects.equals(clickInsideButton.getText(), "Add to cart")) {
// clickInsideButton.click();
// try {
// Thread.sleep(1000);
// } catch (InterruptedException e) {
// throw new RuntimeException(e);
// }
// driver.findElement(By.id("back-to-products")).click();
//
// }
// try {
// Thread.sleep(2000);
// } catch (InterruptedException e) {
// throw new RuntimeException(e);
// }

/*
 * WebElement selecter =
 * driver.findElement(By.xpath("//select[@class='product_sort_container']"));
 * selecter.click();
 * driver.findElement(By.xpath("//option[@value='za']")).click();
 * WebElement startFromZAProduct = driver.findElement(By.xpath(
 * "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']"));
 * if (startFromZAProduct.getText().equals("Add to cart")){
 * startFromZAProduct.click();
 * }
 * else {
 * System.out.println("already add to cart ");
 * }
 */

// selector
/*
 * Select dropdown = new Select(driver.findElement(By.xpath(
 * "//select[@class='product_sort_container']")));
 * dropdown.selectByVisibleText("Name (Z to A)");
 * try {
 * Thread.sleep(2000);
 * } catch (InterruptedException e) {
 * throw new RuntimeException(e);
 * }
 * WebElement startFromZAProduct = driver.findElement(By.xpath(
 * "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']"));
 * startFromZAProduct.click();
 * try {
 * Thread.sleep(2000);
 * } catch (InterruptedException e) {
 * throw new RuntimeException(e);
 * }
 */

// add to cart page
// driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
// try {
// Thread.sleep(2000);
// } catch (InterruptedException e) {
// throw new RuntimeException(e);
// }
// System.out.println(" curront Url: " + driver.getCurrentUrl());
// driver.findElement(By.id("checkout")).click();
// try {
// Thread.sleep(1000);
// } catch (InterruptedException e) {
// throw new RuntimeException(e);
// }
//// checkout page
// System.out.println("current Url: " + driver.getCurrentUrl());
// WebElement firstname = driver.findElement(By.id("first-name"));
// firstname.sendKeys("Meet");
// try {
// Thread.sleep(1000);
// } catch (InterruptedException e) {
// throw new RuntimeException(e);
// }
//
// WebElement lastname = driver.findElement(By.id("last-name"));
// lastname.sendKeys("Patel");
// try {
// Thread.sleep(1000);
// } catch (InterruptedException e) {
// throw new RuntimeException(e);
// }
//
// WebElement postalcode = driver.findElement(By.id("postal-code"));
// postalcode.sendKeys("384151");
// try {
// Thread.sleep(2000);
// } catch (InterruptedException e) {
// throw new RuntimeException(e);
// }
//
// WebElement continuebtn = driver.findElement(By.id("continue"));
// continuebtn.click();
// System.out.println();
// System.out.println("Continue button not working ");
// try {
// Thread.sleep(2000);
// } catch (InterruptedException e) {
// throw new RuntimeException(e);
// }
//// payment page
// WebElement finish = driver.findElement(By.id("finish"));
// finish.click();
// try {
// Thread.sleep(2000);
// } catch (InterruptedException e) {
// throw new RuntimeException(e);
// }
// WebElement goToHOmePage = driver.findElement(By.id("back-to-products"));
// goToHOmePage.click();
// try {
// Thread.sleep(2000);
// } catch (InterruptedException e) {
// throw new RuntimeException(e);
// }
// WebElement navopen = driver.findElement(By.id("react-burger-menu-btn"));
// navopen.click(); WebElement aboutPage =
// driver.findElement(By.cssSelector("#about_sidebar_link"));
// try {
// Thread.sleep(2000);
// } catch (InterruptedException e) {
// throw new RuntimeException(e);
// }
// aboutPage.click();
// try {
// Thread.sleep(2000);
// } catch (InterruptedException e) {
// throw new RuntimeException(e);
// }
// driver.navigate().back();
// try {
// Thread.sleep(2000);
// } catch (InterruptedException e) {
// throw new RuntimeException(e);
// }
//
// System.out.println("logout successfully");
// WebElement logout =
// driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
// logout.click();
// }
// }
// redio button
// driver.get("https://designsystem.digital.gov/components/radio-buttons/");
// driver.manage().window().maximize();
// WebElement redioButton =
// driver.findElement(By.xpath("//body[contains(@class,'page-radio-buttons
// layout-component')]/div[@class='default-container']/div[@class='usa-in-page-nav-container']/main[@id='main-content']/div[@class='styleguide-content
// usa-prose site-prose']/div[@class='usa-accordion usa-accordion--bordered
// site-accordion-code
// site-component-preview']/div[@id='radio-buttons-preview-content']/fieldset[@class='usa-fieldset']/div[3]/label[1]"));
// redioButton.click();
// }
// }

//
//// scroll page
// driver.get("https://www.w3schools.com/html/default.asp");
// driver.manage().window().maximize();
// System.out.println();
// JavascriptExecutor scroll = (JavascriptExecutor)driver;
// // Scroll the window down
// scroll.executeScript("window.scrollTo({ top: 0, behavior: 'smooth' })");
// // Find the element to scroll to
// WebElement scrollDown =
// driver.findElement(By.xpath("//body/div[@id='belowtopnav']/div[@class='w3-row
// w3-white']/div[@id='main']/div[8]/a[1]"));
// // Scroll to the element
// scroll.executeScript("arguments[0].scrollIntoView();", scrollDown);
// }
// }