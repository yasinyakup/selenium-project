package com.yaytech.webtables;

import com.yaytech.util.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HoverTest extends TestBase {

    @Test
    public void test1() throws InterruptedException {
        getDriver().get(BASE_URL+"hovers");
        getDriver().manage().window().fullscreen();
        getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        List<WebElement> imgs = getDriver().findElements(By.tagName("img"));

        int i = 0;
        for (WebElement img : imgs) {
            Actions actions = new Actions(getDriver());
            Thread.sleep(1000);
            actions.moveToElement(img).perform();


            WebElement e = getDriver().findElement(By.xpath("(//div/a)["+ ++i +"]"));
            Assert.assertTrue(e.isEnabled());
        }


    }
}
