package tasks.hurt_me_plenty.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import tasks.hurt_me_plenty.helper.HelperInitializer;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        HelperInitializer.initHelpers(driver);
    }

    protected abstract AbstractPage openPage();
}
