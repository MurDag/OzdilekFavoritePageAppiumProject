package PageObjectModel;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.logging.Logger;

public class AbstractClass {
    protected static AppiumDriver<MobileElement> appiumDriver;
    protected static FluentWait<AppiumDriver<MobileElement>> appiumFluentWait;
    protected static Logger logger;

    AbstractClass(AppiumDriver appiumDriver, Logger logger) {
        this.appiumDriver = appiumDriver;
        this.logger = logger;
    }

    public void click(By element) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 60);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        appiumDriver.findElement(element).click();
        logger.info(element + " adlı elemente tıklandı.");
    }

    public void assertion(By element, String expected) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        Assert.assertEquals(appiumDriver.findElement(element).getText(), expected);
        if (!expected.equals(appiumDriver.findElement(element).getText())) {
            logger.warning("Beklenen değer ve aslında olan değer eşit değil !");
            logger.warning("Actual Value : " + appiumDriver.findElement(element).getText());
            logger.warning("Expected Value : " + expected);
        }
    }

    public void swipeWithLastElement(By element) {
        String tempElementBounds = "";
        while (true) {
            WebDriverWait wait = new WebDriverWait(appiumDriver, 60);
            wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            if (tempElementBounds.equals(appiumDriver.findElement(element).getAttribute("bounds"))) {
                logger.info("En aşağıya kadar Swipe işlemi tamamlandı.");
                break;
            }
            tempElementBounds = appiumDriver.findElement(element).getAttribute("bounds");
            TouchAction action = new TouchAction(appiumDriver);
            Dimension size = appiumDriver.manage().window().getSize();
            int y_start = (int) (size.height * 0.70);
            int y_end = (int) (size.height * 0.10);
            int x = size.width / 2;
            action.press(PointOption.point(x, y_start))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(200)))
                    .moveTo(PointOption.point(x, y_end)).release().perform();
        }

    }

    public void isSelected(By element) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        Assert.assertTrue(Boolean.parseBoolean(appiumDriver.findElement(element).getAttribute("selected")));
        if (Boolean.parseBoolean(appiumDriver.findElement(element).getAttribute("selected"))) {
            logger.info("Elementin selected özelliği true'dur.");
        } else {
            logger.warning("Elementin selected özelliği false'tur.");
        }
    }

    public void isClickable(By element) {
        WebDriverWait wait = new WebDriverWait(appiumDriver, 60);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        Assert.assertFalse(Boolean.parseBoolean(appiumDriver.findElement(element).getAttribute("clickable")));
        if (!Boolean.parseBoolean(appiumDriver.findElement(element).getAttribute("selected"))) {
            logger.info("Elementin clickable özelliği false'tur.");
        } else {
            logger.warning("Elementin clickable özelliği true'dur.");
        }
    }
}
