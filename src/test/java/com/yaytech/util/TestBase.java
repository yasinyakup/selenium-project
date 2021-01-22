package com.yaytech.util;

import com.yaytech.util.BrowserEnum;
import com.yaytech.util.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {
    private WebDriver driver;
    private Actions actions;

     public static final String BASE_URL = "http://practice.cybertekschool.com/";
     public static final String BASE_URL2 = "http://qa2.vytrack.com/";

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeTest
    public void beforeTest(){

        this.driver = WebDriverFactory.getDriver();
        driver.manage().window().fullscreen();
        this.actions = new Actions(this.driver);
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.driver.get(BASE_URL2);
    }


    @AfterTest
    public void afterTest(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            this.driver.quit();
        }

    }
}
