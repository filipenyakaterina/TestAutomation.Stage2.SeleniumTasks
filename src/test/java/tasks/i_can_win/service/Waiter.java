package tasks.i_can_win.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    public static final int WAIT_TIME_OUT = 10;
    private final WebDriverWait waiter;

    public Waiter(WebDriver driver) {
        waiter = new WebDriverWait(driver, WAIT_TIME_OUT);
    }

    public void waitUntilElementBeVisible(WebElement element) {
        waiter.until(ExpectedConditions.visibilityOf(element));
    }
}
