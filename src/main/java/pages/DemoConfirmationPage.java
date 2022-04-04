package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoConfirmationPage {
    @FindBy(xpath = "//div[@class='sweet-alert  showSweetAlert visible']/h2")
    static WebElement confirmationMessage;
    @FindBy(xpath = "//div[@class='sweet-alert  showSweetAlert visible']/p")
    static WebElement info;
    @FindBy(xpath = "//div[10]/p")
    static WebElement confirmCard;
    static WebDriver driver;

    public DemoConfirmationPage(WebDriver driver) {
        DemoConfirmationPage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public static String getConfirmationText() {
        return confirmationMessage.getText();
    }

    public static String getCardConfirmation() {
        return confirmCard.getText();
    }

}
