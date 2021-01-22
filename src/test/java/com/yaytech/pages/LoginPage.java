package com.yaytech.pages;

import com.yaytech.util.BrowserEnum;
import com.yaytech.util.ConfigurationReader;
import com.yaytech.util.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(WebDriverFactory.getDriver(), this);
    }

    @FindBy(id="prependedInput")
    public WebElement usernameInput;

    @FindBy(id="prependedInput2")
    public WebElement passwordInput;

    @FindBy(id="_submit")
    public WebElement submitButton;

    public void login(String username, String password){

        usernameInput.sendKeys(ConfigurationReader.getValue(username));
        passwordInput.sendKeys(ConfigurationReader.getValue(password));
        submitButton.click();

    }

}
