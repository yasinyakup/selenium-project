package com.yaytech.webelement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase{

    @Test
    public void test1(){
        getDriver().get(BASE_URL+"upload");

        WebElement fileInput = getDriver().findElement(By.name("file"));
        WebElement submit = getDriver().findElement(By.id("file-submit"));
        fileInput.sendKeys("C:\\Users\\yyakufu\\Desktop\\java course\\css_compressed.pdf");
        submit.click();

        WebElement upFiles = getDriver().findElement(By.id("uploaded-files"));


        Assert.assertEquals(upFiles.getText(), "css_compressed.pdf");


    }

}
