package tasks.hurt_me_plenty.pageElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tasks.hurt_me_plenty.helper.Executor;
import tasks.hurt_me_plenty.helper.Waiter;

public class MdSelect {
    private final WebElement select;
    private WebElement option;
    private WebElement optionDiv;

    public MdSelect(WebElement select) {
        this.select = select;
    }

    private void expandSelect() {
        Executor.clickElement(select);
        Waiter.waitUntilAttributeAriaExpandedToBe(select, true);
    }

    private void findSelectOption(String optionText) {
        String elementXpath = "//div[@class = 'md-select-menu-container md-active md-clickable']//div[contains(text(),'" + optionText + "')]";
        By elementLocator = By.xpath(elementXpath);

        Waiter.waitUntilElementAppears(elementLocator);
        optionDiv = select.findElement(elementLocator);
        option = select.findElement(By.xpath(elementXpath + "/ancestor::md-option"));
    }

    private void selectOption() {
        Executor.clickElement(option);
        Executor.clickElement(optionDiv);
        Waiter.waitUntilElementToBeVisible(select);
    }

    public void selectByValue(String optionText) {
        expandSelect();
        findSelectOption(optionText);
        selectOption();
    }
}
