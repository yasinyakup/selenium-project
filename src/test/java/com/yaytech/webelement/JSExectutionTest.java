package com.yaytech.webelement;

import com.yaytech.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class JSExectutionTest extends TestBase {

    @Test
    public void test1() throws InterruptedException {
        getDriver().get(BASE_URL+"dynamic_controls");

        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        WebDriverWait wait = new WebDriverWait(getDriver(), 10);

        WebElement button = getDriver().findElement(By.cssSelector("#input-example>button"));
        button.click();


        WebElement input = getDriver().findElement(By.cssSelector("#input-example>input"));
        jse.executeScript("arguments[0].setAttribute('value', 'Hi ')",input);

        wait.until(ExpectedConditions.elementToBeClickable(input));
        input.sendKeys("Yasin yakup");




        jse.executeScript("console.log('test')");


    }
}
