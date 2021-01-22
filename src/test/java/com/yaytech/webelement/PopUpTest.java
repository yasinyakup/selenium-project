package com.yaytech.webelement;

import com.yaytech.util.BrowserEnum;
import com.yaytech.util.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PopUpTest {
    WebDriverFactory webDriverFactory;
    WebDriver driver;


    @BeforeTest
    public void beforeTest(){
        this.driver = WebDriverFactory.getDriver();

    }

    @Test
    public void test1(){
        this.driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.findElement(By.xpath("//button[.='Destroy the World']")).click();
        driver.findElement(By.xpath("//button[.='No']")).click();

    }

    @Test
    public void test2() throws InterruptedException {
        this.driver.get("http://practice.cybertekschool.com/javascript_alerts");
        driver.findElement(By.xpath("//button[3]")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.sendKeys("I am sure!");
        Thread.sleep(1000);
        alert.accept();


    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
