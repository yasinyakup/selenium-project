package com.yaytech.webelement;

import com.yaytech.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUploadTest extends TestBase {

    @Test
    public void test1(){
        getDriver().get(BASE_URL+"upload");

        System.out.println(System.getProperty("os.name"));
        String project_path=System.getProperty("user.dir");
        String file_path = "/src/test/resources/testfile.txt";

        String full_path = project_path + file_path;

        System.out.println(full_path);
        WebElement fileInput = getDriver().findElement(By.name("file"));
        WebElement submit = getDriver().findElement(By.id("file-submit"));
        fileInput.sendKeys(full_path);
        submit.click();




        WebElement upFiles = getDriver().findElement(By.id("uploaded-files"));


        Assert.assertEquals(upFiles.getText(), "testfile.txt");


    }

}
