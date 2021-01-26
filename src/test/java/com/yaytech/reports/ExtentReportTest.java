package com.yaytech.reports;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration;
import com.yaytech.util.ConfigurationReader;
import com.yaytech.util.WebDriverFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.reporters.TestHTMLReporter;

public class ExtentReportTest {
    ExtentReports reports;

   ExtentHtmlReporter htmlReporter;
   ExtentSparkReporter extentSparkReporter;

    ExtentTest extentTest;


    @BeforeTest
    public void beforeTest(){

        String projectPath = System.getProperty("user.dir");
        String filePath = projectPath+"/test-output/report1.html";

        reports = new ExtentReports();

        extentSparkReporter = new ExtentSparkReporter(filePath);
        extentSparkReporter.config().setReportName("VyTrack Smoke Test1");
        reports.attachReporter(extentSparkReporter);

        /*htmlReporter = new ExtentHtmlReporter(filePath);
        htmlReporter.config().setReportName("VyTrack Smoke Test");
        reports.attachReporter(htmlReporter);*/


        reports.setSystemInfo("Environment", "QA");
        reports.setSystemInfo("Browser", ConfigurationReader.getValue("browser"));
        reports.setSystemInfo("OS", System.getProperty("os.name"));

    }

    @Test
    public void test1(){
        extentTest = reports.createTest("Y001 longin as driver test");

        extentTest.info("Open Chrome browser");
        extentTest.info("enter username and password");
        extentTest.info("Click submit key");
        extentTest.info("open dashboard page");
        extentTest.pass("Y001 is passed");



    }

    @AfterTest
    public void afterTest(){
        reports.flush();
        WebDriverFactory.closeDriver();
    }
}
