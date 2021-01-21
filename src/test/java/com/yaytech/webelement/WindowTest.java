package com.yaytech.webelement;

import com.yaytech.util.BrowserEnum;
import com.yaytech.util.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Properties;
import java.util.Set;

public class WindowTest {
    WebDriverFactory webDriverFactory;
    WebDriver driver;

    @BeforeTest
    public void beforeTest(){
        this.webDriverFactory = new WebDriverFactory();
        this.driver = this.webDriverFactory.getDriver(BrowserEnum.CHROME);
    }
    @FindBy(id = "test")
    WebElement e;
    Properties p;
    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/windows");
        driver.findElement(By.linkText("Click Here")).click();

        System.out.println(driver.getPageSource());
        System.out.println(driver.getTitle());
        String currentHandle = driver.getWindowHandle();





        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles.size());

        for (String handle: windowHandles
             ) {
            if(!currentHandle.equals(handle)){
                driver.switchTo().window(handle);
            }
        }
        System.out.println(driver.getTitle());
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
