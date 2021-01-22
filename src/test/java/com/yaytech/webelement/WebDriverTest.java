package com.yaytech.webelement;

import com.yaytech.util.BrowserEnum;
import com.yaytech.util.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebDriverTest {

    private WebDriver driver;

    public WebDriverTest() {
        driver = WebDriverFactory.getDriver();
    }

    @Test
    public void test1() {
        this.driver.get("https://www.google.com");
    }


    @Test
    public void test2() {
        test1();
        WebElement input = this.driver.findElement(By.name("q"));
        input.sendKeys("advanced concept of java");
        WebElement gBtn = this.driver.findElement(By.id("gsr"));
        gBtn.click();


    }


}
