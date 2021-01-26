package com.yaytech.datatransfer;

import com.yaytech.pages.LoginPage;
import com.yaytech.util.BrowserUtils;
import com.yaytech.util.ExcelUtil;
import com.yaytech.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTestForAllUsersFromExcel extends TestBase {

    @DataProvider
    public Object [][] getUserDataFromExcel(){
        ExcelUtil qa3_short = new ExcelUtil("src/test/resources/Vytracktestdata.xlsx", "QA3-short");
        return qa3_short.getDataArrayWithoutFirstRow();
    }

    @Test(dataProvider = "getUserDataFromExcel")
    public void test1(String username, String password, String firstname, String lastname){

        LoginPage loginPage = new LoginPage();
        loginPage.loginDirectWithoutConfigurationFile(username, password);

        BrowserUtils.waitForClickablility(getDriver().findElement(By.cssSelector("#user-menu>a")),5);
        getDriver().findElement(By.cssSelector("#user-menu>a")).click();

        BrowserUtils.waitForClickablility(getDriver().findElement(By.xpath("//*[.='My User']")),5);
        getDriver().findElement(By.xpath("//*[.='My User']")).click();

        BrowserUtils.waitFor(5);

        BrowserUtils.waitForVisibility(getDriver().findElement(By.cssSelector(".pull-left>h1")), 5);
        String actual = getDriver().findElement(By.cssSelector(".pull-left>h1")).getText();
        String expected = firstname+" "+lastname;

        Assert.assertEquals(actual, expected, "Please verify first and last name");
    }
}
