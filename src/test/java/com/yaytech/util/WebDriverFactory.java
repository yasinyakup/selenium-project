package com.yaytech.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory {

    public WebDriver getDriver(BrowserEnum browser) {
        switch (browser) {
            case CHROME : {
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
            case IE :{
                WebDriverManager.iedriver().setup();
                return new InternetExplorerDriver();
            }
            case EDGE : {
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            }
            case OPERA :{
                WebDriverManager.operadriver();
                return new OperaDriver();
            }
            default :
                throw new RuntimeException("this driver is not supported. please check factory type");
        }
    }
}
