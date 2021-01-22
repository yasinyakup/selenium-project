package com.yaytech.webelement;

import com.yaytech.util.BrowserEnum;
import com.yaytech.util.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxTest {
  private final WebDriver driver;

  public CheckBoxTest(){

      this.driver = WebDriverFactory.getDriver();
  }

  @Test
  public void test1() throws InterruptedException {
      driver.get("http://practice.cybertekschool.com/checkboxes");
      WebElement chek1 = driver.findElement(By.xpath("//input[1]"));
      WebElement chek2 = driver.findElement(By.xpath("//input[2]"));

      chek1.click();
      System.out.println(chek1.isSelected());
      chek2.click();
      System.out.println(chek2.isSelected());

      Assert.assertTrue(chek1.isSelected());
      Assert.assertFalse(chek2.isSelected());

      chek2.click();

      Assert.assertTrue(chek2.isSelected());


      Thread.sleep(2000);

      driver.quit();

  }
}
