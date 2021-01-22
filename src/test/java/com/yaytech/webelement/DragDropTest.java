package com.yaytech.webelement;

import com.yaytech.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class DragDropTest extends TestBase {

    @Test
    public void test1() throws InterruptedException {
        getDriver().get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        //List<WebElement> elements = getDriver().findElements(By.xpath("//*[.='Accept and Clode']"));
        List<WebElement> elements2 = getDriver().findElements(By.xpath("//*[.='Accept Cookies']"));
        WebDriverWait wait = new WebDriverWait(getDriver(), 5);
        //wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        wait.until(ExpectedConditions.visibilityOfAllElements(elements2));
      /*  if(!elements.isEmpty()){
            elements.forEach(webElement -> webElement.click());
        }*/
        if (!elements2.isEmpty()){
            elements2.forEach(webElement -> webElement.click());
        }

       // WebDriverWait wait = new WebDriverWait(getDriver(), 10);

       /* WebElement accept =  getDriver().findElement(By.xpath("//*[.='Accept Cookies']"));
        wait.until(ExpectedConditions.elementToBeClickable(accept));
        accept.click();*/

        Thread.sleep(1000);
        WebElement source = getDriver().findElement(By.id("draggable"));
        WebElement target = getDriver().findElement(By.id("droptarget"));

        Actions actions = new Actions(getDriver());
        actions.clickAndHold(source).moveToElement(target).release().perform();

       // actions.dragAndDrop(source, target).perform();
        Thread.sleep(2000);

        Assert.assertEquals(target.getText(), "You did great!");


    }

}
