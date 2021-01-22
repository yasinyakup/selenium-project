package com.yaytech.webtables;

import com.yaytech.pages.LoginPage;
import com.yaytech.util.ConfigurationReader;
import com.yaytech.util.TestBase;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {

    @Test
    public void test1(){
        LoginPage loginPage = new LoginPage();

        loginPage.login("driver_username", "driver_password");
    }

    @Test
    public void test2(){
        LoginPage loginPage = new LoginPage();
        loginPage.login("salesmanager_username", "salesmanager_password");
    }
}
