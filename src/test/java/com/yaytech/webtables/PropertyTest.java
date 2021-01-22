package com.yaytech.webtables;

import com.yaytech.util.ConfigurationReader;
import com.yaytech.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class PropertyTest extends TestBase {

    @Test
    public void test1(){

        getDriver().get(ConfigurationReader.getValue("url"));
        getDriver().findElement(By.id("prependedInput")).sendKeys(ConfigurationReader.getValue("driver_username"));
        getDriver().findElement(By.id("prependedInput2")).sendKeys(ConfigurationReader.getValue("driver_password"));

        getDriver().findElement(By.id("_submit")).click();
    }
}
