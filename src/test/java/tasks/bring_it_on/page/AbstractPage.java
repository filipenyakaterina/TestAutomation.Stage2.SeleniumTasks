package tasks.bring_it_on.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import tasks.bring_it_on.service.Waiter;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected Waiter waiter;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        waiter = new Waiter(driver);
    }

    protected abstract AbstractPage openPage();
}
