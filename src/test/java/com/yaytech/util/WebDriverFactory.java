package com.yaytech.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverFactory {

    private static WebDriver driver;

    private WebDriverFactory(WebDriver driver) {
        this.driver = driver;
    }

    public static WebDriver getDriver() {
        BrowserEnum browser = BrowserEnum.getValue(ConfigurationReader.getValue("browser"));
        if (driver == null) {
            switch (browser) {
                case CHROME: {
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                }
                case CHROME_HEADLESS:{
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    //options.setHeadless(true);
                    //options.addArguments("--disable-gpu");
                   driver = new ChromeDriver(options);
                   break;
                }
                case IE: {
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                }
                case EDGE: {
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                }
                case OPERA: {
                    WebDriverManager.operadriver();
                    driver = new OperaDriver();
                    break;
                }
                default:
                    throw new RuntimeException("this driver is not supported. please check factory type");
            }
        }
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null) {
            driver.quit();
            driver = null;
        }
    }
}
