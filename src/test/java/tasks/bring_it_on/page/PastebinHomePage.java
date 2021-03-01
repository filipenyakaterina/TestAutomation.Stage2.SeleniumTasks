package tasks.bring_it_on.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import tasks.bring_it_on.dataEntity.Paste;
import tasks.bring_it_on.element.PastebinSelect;

public class PastebinHomePage extends AbstractPage {
    public static final String HOMEPAGE_URL = "https://pastebin.com/";

    @FindBy(id = "postform-text")
    private WebElement codeInput;

    @FindBy(xpath = "//div[@class='content__title -paste']")
    private WebElement pasteFormTitle;

    @FindBy(id = "postform-format")
    private WebElement pasteSyntaxHighlightingSelect;

    @FindBy(id = "postform-expiration")
    private WebElement pasteExpirationSelect;

    @FindBy(id = "postform-name")
    private WebElement pasteNameInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createButton;

    public PastebinHomePage(WebDriver driver) {
        super(driver);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public PasteCreatingResultPage createPaste(Paste paste) {
        codeInput.sendKeys(paste.getCode());
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", pasteFormTitle);
        new PastebinSelect(driver, pasteSyntaxHighlightingSelect).selectOption(paste.getSyntaxHighlightingValue());
        new PastebinSelect(driver, pasteExpirationSelect).selectOption(paste.getPasteExpirationValue());
        pasteNameInput.sendKeys(paste.getTitle());
        createButton.click();
        waiter.waitUntilPostViewBePresent();
        return new PasteCreatingResultPage(driver);
    }
}
