package com.yaytech.webelement;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionJsTest extends TestBase{

    @Test
    public void test1(){
        getDriver().get(BASE_URL+"hovers");

        WebElement img = getDriver().findElement(By.xpath("(//img)[1]"));

        Actions actions = new Actions(getDriver());

        actions.moveToElement(img).perform();

        WebElement text = getDriver().findElement(By.xpath("(//h5)[1]"));

        Assert.assertTrue(text.isDisplayed());


    }
}
