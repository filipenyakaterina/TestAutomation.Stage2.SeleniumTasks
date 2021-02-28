package tasks.i_can_win.element;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import tasks.i_can_win.service.Waiter;

import java.util.List;
import java.util.Optional;

public class PastebinSelect {
    public static final String VALUE_ATTRIBUTE = "value";
    public static final String SPAN_XPATH = "./following::span[1]";

    private final WebDriver driver;
    private final Select select;
    private final WebElement spanOfSelect;

    public PastebinSelect(WebDriver driver, WebElement select) {
        this.driver = driver;
        this.select = new Select(select);
        spanOfSelect = select.findElement(By.xpath(SPAN_XPATH));
    }

    private void openDropDownList() {
        new Waiter(driver).waitUntilElementBeVisible(spanOfSelect);
        spanOfSelect.click();
    }

    private void selectItem(int itemNumber) {
        Actions actions = new Actions(driver);
        for (int i = 0; i < itemNumber; i++) {
            actions.sendKeys(Keys.ARROW_DOWN);
        }
        actions.sendKeys(Keys.ENTER).build().perform();
    }

    public void selectOption(String optionValue) {
        openDropDownList();
        List<WebElement> options = select.getOptions();
        Optional<WebElement> selectedOption = options.stream().filter(option ->
                option.getAttribute(VALUE_ATTRIBUTE).equalsIgnoreCase(optionValue)).findFirst();
        selectedOption.ifPresent(option -> {
            selectItem(options.indexOf(selectedOption.get()));
        });
    }
}
