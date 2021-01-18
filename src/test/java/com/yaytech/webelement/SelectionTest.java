package com.yaytech.webelement;

import com.yaytech.util.BrowserEnum;
import com.yaytech.util.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class SelectionTest {
    WebDriverFactory webDriverFactory;
    WebDriver driver;
    public SelectionTest() {
        this.webDriverFactory = new WebDriverFactory();
        this.driver = this.webDriverFactory.getDriver(BrowserEnum.CHROME);

    }

    @BeforeTest
    public void beforeTest(){
        this.driver.get("http://practice.cybertekschool.com/dropdown");
    }


    @Test
    public void test1(){
        WebElement dropdown = driver.findElement(By.id(("dropdown")));
        WebElement state = driver.findElement(By.id(("state")));
        System.out.println(dropdown.getAttribute(""));
        System.out.println(dropdown.getTagName());
        System.out.println(dropdown.getClass());

        Select select = new Select(dropdown);
        Select selectState = new Select(state);
        select.selectByIndex(1);
        selectState.selectByVisibleText("New York");


        List<WebElement> selects = dropdown.findElements(By.xpath("//select"));
        System.out.println(selects.size());

        for (WebElement e: selects
             ) {
            Select s = new Select(e);
            if(e.getAttribute("id").equals("state"))
            System.out.println("s.getFirstSelectedOption = " + s.getFirstSelectedOption().getText());
            for (WebElement o: s.getOptions()
                 ) {
                System.out.println(o.getText());
                
            }
            
        }
    }

    @AfterTest
    public void afterTest() throws InterruptedException {
        Thread.sleep(2000);
        this.driver.quit();
    }
}

