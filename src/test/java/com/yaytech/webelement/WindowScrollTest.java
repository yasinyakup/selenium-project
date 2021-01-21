package com.yaytech.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WindowScrollTest extends TestBase{

    @Test
    public void test2() throws InterruptedException {
        getDriver().get(BASE_URL+"infinite_scroll");

        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        for (int i = 0; i<3; i++){
            Thread.sleep(1000);
            jse.executeScript("window.scrollBy(0,250)");
        }

        getDriver().navigate().to("https://www.amazon.com");


       WebElement link = getDriver().findElement(By.className("navFooterBackToTopText"));
       jse.executeScript("arguments[0].scrollIntoView(true)", link);
        System.out.println(link.getText());


    }
}
