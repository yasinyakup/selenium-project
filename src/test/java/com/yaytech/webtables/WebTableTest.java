package com.yaytech.webtables;

import com.yaytech.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WebTableTest extends TestBase {

    @Test
    public void test1(){

        getDriver().get(BASE_URL+ "tables");
        WebElement table = getDriver().findElement(By.xpath("(//table)[1]"));
        System.out.println(table.getText());

        System.out.println(getDriver().findElements(By.xpath("(//table)[1]//th")).size());

        //find all row and columns

        //find siblings of the know element
    }
}
