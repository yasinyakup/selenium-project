package com.yaytech.webtables;

import com.yaytech.pages.CalendarEventsPage;
import com.yaytech.pages.DashboardPage;
import com.yaytech.pages.LoginPage;
import com.yaytech.util.BrowserUtils;
import com.yaytech.util.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubtitleTest extends TestBase {

    @Test
    public void test1(){
        LoginPage loginPage = new LoginPage();
        //loginPage.login("salesmanager_username", "salesmanager_password");
        loginPage.login("driver_username", "driver_password");

        String expectedSubtitle = "Quick Launchpad";
        //String expectedSubtitle = "Dashboard";


        DashboardPage dashboardPage = new DashboardPage();
        String actualSubtitle = dashboardPage.getPageSubTitle();

        Assert.assertEquals(actualSubtitle, expectedSubtitle, "Please Verify Subtitle");

        dashboardPage.navigateToModule("Activities","Calendar Events");
        BrowserUtils.waitFor(1);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        System.out.println(calendarEventsPage.getPageSubTitle());

        Assert.assertEquals(calendarEventsPage.getPageSubTitle(), "Calendar Events");
    }
}
