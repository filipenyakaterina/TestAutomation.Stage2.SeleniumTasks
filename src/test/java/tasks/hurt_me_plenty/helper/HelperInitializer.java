package tasks.hurt_me_plenty.helper;

import org.openqa.selenium.WebDriver;

public class HelperInitializer {

    public static void initHelpers(WebDriver driver) {
        new Waiter(driver);
        new Switcher(driver);
        new Executor(driver);
    }
}
