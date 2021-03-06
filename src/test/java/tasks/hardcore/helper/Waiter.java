package tasks.hardcore.helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter extends Helper {
    public static final int WAITING_PERIOD = 100;
    private static final int EXPECTED_WINDOW_HANDLES_COUNT = 2;
    private static final String ARIA_EXPANDED_ATTRIBUTE = "aria-expanded";
    private static final String VALUE_ATTRIBUTE = "value";
    private static final String EMAIL_FEATURE = "@";

    private static WebDriverWait driverWait;

    Waiter(WebDriver driver) {
        super(driver);
        driverWait = new WebDriverWait(Waiter.driver, WAITING_PERIOD);
    }

    public static void waitUntilElementToBeVisible(WebElement element) {
        driverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementAppears(By locator) {
        driverWait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void waitUntilEmailInValueAppears(WebElement element) {
        driverWait.until(ExpectedConditions.and(ExpectedConditions.attributeToBeNotEmpty(element, VALUE_ATTRIBUTE),
                ExpectedConditions.attributeContains(element, VALUE_ATTRIBUTE, EMAIL_FEATURE)));
    }

    public static void waitUntilAttributeAriaExpandedToBe(WebElement mdSelect, Boolean attributeValue) {
        driverWait.until(ExpectedConditions.attributeToBe(mdSelect, ARIA_EXPANDED_ATTRIBUTE, attributeValue.toString()));
    }

    public static void waitUntilTextToBe(WebElement element, String text) {
        driverWait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    public static void waitUntilNewWindowHandleAppear() {
        driverWait.until(driver -> driver.getWindowHandles().size() == EXPECTED_WINDOW_HANDLES_COUNT);
    }

    public static void waitForFrame(String frameName) {
        new WebDriverWait(driver, WAITING_PERIOD).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
    }

    public static void waitForFrame(int frameNumber) {
        new WebDriverWait(driver, WAITING_PERIOD).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNumber));
    }
}
