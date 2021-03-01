package tasks.bring_it_on.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    public static final int WAIT_TIME_OUT = 10;
    public static final By POST_VIEW_LOCATOR = By.xpath("//div[@class='post-view']");

    private final WebDriverWait waiter;

    public Waiter(WebDriver driver) {
        waiter = new WebDriverWait(driver, WAIT_TIME_OUT);
    }

    public void waitUntilElementBeVisible(WebElement element) {
        waiter.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitUntilPostViewBePresent() {
        waiter.until(ExpectedConditions.visibilityOfElementLocated(POST_VIEW_LOCATOR));
    }
}
