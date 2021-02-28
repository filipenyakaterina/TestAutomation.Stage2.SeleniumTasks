package tasks.i_can_win.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tasks.i_can_win.element.PastebinSelect;

public class PastebinHomePage {
    private static final String HOMEPAGE_URL = "https://pastebin.com/";

    private final WebDriver driver;

    @FindBy(id = "postform-text")
    private WebElement codeInput;

    @FindBy(id = "postform-expiration")
    private WebElement pasteExpirationSelect;

    @FindBy(id = "postform-name")
    private WebElement pasteNameInput;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement createButton;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
    }

    public void createPaste(String codeText, String pasteExpirationValue, String pasteName) {
        codeInput.sendKeys(codeText);
        new PastebinSelect(driver, pasteExpirationSelect).selectOption(pasteExpirationValue);
        pasteNameInput.sendKeys(pasteName);
        createButton.click();
    }
}
