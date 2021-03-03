package tasks.hurt_me_plenty.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Optional;

public class PriceCalculationResult extends AbstractPage {

    @FindBy(xpath = "//md-card-content[@id = 'resultBlock']//div[contains(text(),'VM class')]")
    private WebElement VMclass;

    @FindBy(xpath = "//md-card-content[@id = 'resultBlock']//div[contains(text(),'Instance type')]")
    private WebElement instanceType;

    @FindBy(xpath = "//md-card-content[@id = 'resultBlock']//div[contains(text(),'Region')]")
    private WebElement region;

    @FindBy(xpath = "//md-card-content[@id = 'resultBlock']//div[contains(text(),'Commitment term')]")
    private WebElement commitmentTerm;

    @FindBy(xpath = "//md-card-content[@id = 'resultBlock']//b[contains(text(),'Total Estimated Cost')]")
    private WebElement totalEstimateCost;

    private final By localSSDLocator = By.xpath("//md-card-content[@id = 'resultBlock']//div[contains(text(),'local SSD')]");

    protected PriceCalculationResult(WebDriver driver) {
        super(driver);
        if (!driver.getCurrentUrl().contains(GoogleCloudPlatformPricingCalculatorPage.CALCULATOR_URL)) {
            throw new IllegalStateException("This is not the Google Cloud Platform Pricing Calculator page!");
        }
    }

    protected AbstractPage openPage() {
        throw new RuntimeException("Cannot open page with the result of price calculation without providing data entry to the Google Cloud Platform Pricing Calculator.");
    }

    public String getVMclass() {
        return VMclass.getText();
    }

    public String getInstanceType() {
        return instanceType.getText();
    }

    public String getRegion() {
        return region.getText();
    }

    public String getLocalSSD() {
        String localSSDValue;

        Optional<WebElement> optionalLocalSSD = driver.findElements(localSSDLocator).stream().findFirst();
        localSSDValue = optionalLocalSSD.isPresent() ? optionalLocalSSD.get().getText() : "";
        return localSSDValue;
    }

    public String getCommitmentTerm() {
        return commitmentTerm.getText();
    }

    public String getTotalEstimateCost() {
        return totalEstimateCost.getText();
    }
}
