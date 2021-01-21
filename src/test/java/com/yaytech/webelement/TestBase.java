package com.yaytech.webelement;

import com.yaytech.util.BrowserEnum;
import com.yaytech.util.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {
    private WebDriverFactory webDriverFactory;
    private WebDriver driver;

     static final String BASE_URL = "http://practice.cybertekschool.com/";

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeTest
    public void beforeTest(){
        this.webDriverFactory = new WebDriverFactory();
        this.driver = this.webDriverFactory.getDriver(BrowserEnum.CHROME);

        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
