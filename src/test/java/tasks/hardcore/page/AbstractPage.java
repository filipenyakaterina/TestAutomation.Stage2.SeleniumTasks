package tasks.hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import tasks.hardcore.helper.HelperInitializer;

public abstract class AbstractPage {
    protected WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        HelperInitializer.initHelpers(driver);
    }

    public abstract AbstractPage openPage();
}
