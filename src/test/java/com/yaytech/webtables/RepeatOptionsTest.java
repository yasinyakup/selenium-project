package com.yaytech.webtables;

import com.yaytech.pages.*;
import com.yaytech.util.BrowserUtils;
import com.yaytech.util.TestBase;
import org.testng.annotations.Test;

public class RepeatOptionsTest extends TestBase {

    @Test
    public void test1() throws InterruptedException {
        LoginPage loginPage = new LoginPage();
        loginPage.login("driver_username","driver_password");

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        Thread.sleep(7000);
         calendarEventsPage.createCalendarEvent.click();

        CreateCalendarEventsPage createCalendarEventsPage = new CreateCalendarEventsPage();
        BrowserUtils.waitForClickablility(createCalendarEventsPage.repeat, 5);
        Thread.sleep(5000);
        createCalendarEventsPage.repeat.click();
    }
}
