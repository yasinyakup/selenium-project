package com.yaytech.pages;

import com.yaytech.util.WebDriverFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
    }
}
