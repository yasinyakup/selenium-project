package com.yaytech.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class IFrameTest extends TestBase{

    @Test
    public void test1(){
        this.getDriver().get(BASE_URL+"iframe");
        System.out.println(getDriver().getTitle());

        getDriver().switchTo().frame("mce_0_ifr");

        WebElement text = getDriver().findElement(By.id("tinymce"));
        System.out.println(text.getText());

        //getDriver().switchTo().defaultContent();
        getDriver().switchTo().parentFrame();

        System.out.println(getDriver().findElement(By.tagName("H3")));
    }

    @Test
    public void test2(){
        this.getDriver().get(BASE_URL+"nested_frames");
        getDriver().switchTo().frame(0);
        getDriver().switchTo().frame(1);
        WebElement mElement = getDriver().findElement(By.id("content"));
        System.out.println(mElement.getText());
    }
}
