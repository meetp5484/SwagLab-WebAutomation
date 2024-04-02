package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class checkboxTest {
    public static void chekcbox(WebDriver driver) {
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_input_type_checkbox");
        WebElement checkbox = driver.findElement(By.id("//input[@id='vehicle1']"));
        checkbox.click();
    }
}
