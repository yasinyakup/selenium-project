package com.yaytech.webelement;

import com.yaytech.util.BrowserEnum;
import com.yaytech.util.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicElementTest {
    private WebDriver driver;
    private final String URL = "http://practice.cybertekschool.com/dynamic_controls";

    public DynamicElementTest(){
        this.driver = WebDriverFactory.getDriver();

    }

    @Test
    public void test1(){

        driver.get(this.URL);
        WebElement webElement = driver.findElement(By.cssSelector("#input-example>input"));

        Assert.assertFalse(webElement.isEnabled());
//        webElement.sendKeys("hello");
    }


}
