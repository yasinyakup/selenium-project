package com.yaytech.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    private WebDriver driver;
    private Actions actions;
    private final String PROJECT_PATH = System.getProperty("user.dir");

    public ExtentReports report;
    public  ExtentSparkReporter sparkReporter;
    public ExtentTest extentTest;

     public static final String BASE_URL = "http://practice.cybertekschool.com/";
     public static final String BASE_URL2 = "http://qa3.vytrack.com/";

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeTest
    public void beforeTest(){
        String filePath= PROJECT_PATH+"/test-output/report2.html";
        report = new ExtentReports();
        sparkReporter = new ExtentSparkReporter(filePath);
        sparkReporter.config().setReportName("Smoke test");
        report.attachReporter(sparkReporter);




    }

    @BeforeMethod
    public void beforeMethod(){
        this.driver = WebDriverFactory.getDriver();
        driver.manage().window().fullscreen();
        this.actions = new Actions(this.driver);
        this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        this.driver.get(BASE_URL2);
    }

    @AfterMethod
    public void afterMethod(ITestResult iTestResult){
        try {
            //if test fails
          if(iTestResult.getStatus()==ITestResult.FAILURE){
              extentTest.fail(iTestResult.getName());

              String screenShotpath = BrowserUtils.getScreenshot(iTestResult.getName());

              extentTest.addScreenCaptureFromPath(screenShotpath);

              extentTest.fail(iTestResult.getThrowable());
          }


            Thread.sleep(2000);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }finally {
            WebDriverFactory.closeDriver();
        }

    }

    @AfterTest
    public void afterTest(){
        report.flush();

    }
}
