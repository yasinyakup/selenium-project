package com.yaytech.webelement;

import com.yaytech.util.BrowserEnum;
import com.yaytech.util.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class AttributeTest {

        WebDriverFactory webDriverFactory;
        WebDriver driver;

        public AttributeTest() {
            driver= WebDriverFactory.getDriver();
        }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement blueButton = driver.findElement(By.id("blue"));


        System.out.println(blueButton.getAttribute("type"));

        System.out.println(blueButton.getAttribute("checked"));
        System.out.println(blueButton.getAttribute("name"));
        System.out.println(blueButton.getAttribute("outerHTML"));
        System.out.println(blueButton.getTagName());
        System.out.println(blueButton.getText());


        List<WebElement> labels = driver.findElements(new By.ByCssSelector("H6"));
        for (WebElement e: labels
             ) {
            System.out.println(e.getText());
        }

        Thread.sleep(3000);
        driver.quit();
    }
}
