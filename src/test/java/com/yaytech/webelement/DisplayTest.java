package com.yaytech.webelement;

import com.yaytech.util.BrowserEnum;
import com.yaytech.util.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DisplayTest {
    WebDriverFactory webDriverFactory;
    WebDriver driver;
    public DisplayTest() {
        this.driver= WebDriverFactory.getDriver();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");

        WebElement button = driver.findElement(By.cssSelector("#start>.btn"));

        button.click();
        Thread.sleep(5000);
        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("pwd"));
        WebElement submit = driver.findElement(By.cssSelector(".col-sm-10> .btn"));

        username.sendKeys("yasinyakup@gmail.com");
        password.sendKeys("yasin123456");
        Thread.sleep(2000);
        Assert.assertTrue(username.isDisplayed());
        Assert.assertTrue(password.isDisplayed());
        submit.click();

        Thread.sleep(2000);
        driver.quit();
    }
}
