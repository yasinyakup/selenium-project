package com.yaytech.reports;

import com.yaytech.pages.LoginPage;
import com.yaytech.util.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestReport extends TestBase {


    @Test
    public void test1(){
        extentTest = report.createTest("Driver Login Test");

        LoginPage loginPage = new LoginPage();
        extentTest.info("Enter username: User1");

        loginPage.login("driver_username", "driver_password");
        extentTest.info("Enter Password: UserUser123");

        extentTest.info("Click submit button");
        Assert.assertNotEquals(getDriver().getCurrentUrl(), BASE_URL2);
        extentTest.pass("Login test is passed for driver");

        System.out.println(getDriver().getCurrentUrl());
    }


    @Test
    public void test2(){
        extentTest= report.createTest("Sales Manager Login test");
        LoginPage loginPage = new LoginPage();

        extentTest.info("Open Chrome Browser");
        extentTest.info("Enter username: Salesmanager120");
        loginPage.login("salesmanager_username", "salesmanager_password");

        extentTest.info("Enter password: UserUser123");
        extentTest.info("Click Login button");
        Assert.assertNotEquals(getDriver().getCurrentUrl(), BASE_URL2);
        extentTest.pass("Sales manager login test is passed");
    }
}
