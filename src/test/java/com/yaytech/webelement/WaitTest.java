package com.yaytech.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest extends TestBase{

    @Test
    public void test1() throws InterruptedException {
        this.getDriver().get(BASE_URL+"dynamic_loading/3");

        //Thread.sleep(6000);
        //getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(getDriver(), 3);
        WebElement input = getDriver().findElement(By.id("username"));
        wait.until(ExpectedConditions.visibilityOf(input));



        input.sendKeys("Yasin yakup");

    }
}
