package com.yaytech.webelement;

import com.yaytech.util.BrowserEnum;
import com.yaytech.util.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest {
    private WebDriver driver;
    private final String URL = "http://practice.cybertekschool.com/radio_buttons";
    Logger logger;
    org.testng.log4testng.Logger l = org.testng.log4testng.Logger.getLogger(RadioButtonTest.class);

    public RadioButtonTest(){
        this.driver = WebDriverFactory.getDriver();
        logger = LoggerFactory.getLogger(RadioButtonTest.class);
    }

    @Test
    public void testRadioButton(){
//        driver.manage().window().fullscreen();
        driver.get(this.URL);
        WebElement blueRadioButton = driver.findElement(By.id("blue"));

       Assert.assertTrue(blueRadioButton.isSelected(), "blue not selected");
       Assert.assertTrue(blueRadioButton.isDisplayed(), "bue not displayed");
       Assert.assertTrue(blueRadioButton.isEnabled(), "blue button not enabled");

        WebElement greenRadioButton = driver.findElement(By.id("green"));

        Assert.assertFalse(greenRadioButton.isSelected(), "green not selected");
        Assert.assertTrue(greenRadioButton.isDisplayed(), "green not displayed");
        Assert.assertFalse(greenRadioButton.isEnabled(), "green button not enabled");

        logger.info("Test have compledted successfully!");
        l.info("Test have completed successfully!-testng");

    }
}
