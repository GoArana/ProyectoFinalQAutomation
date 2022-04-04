package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoCartPage {

    @FindBy(xpath = "//td[2]")
    WebElement model;
    @FindBy(xpath = "//td[3]")
    WebElement price;
    @FindBy(xpath = "//div[2]/button")
    WebElement placeOrderButton;
    WebDriver driver;

    public DemoCartPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getModel() {
        return model.getText();
    }

    public String getPrice() {
        return price.getText();
    }

    public void clickOnPlaceOrderButton() {
        placeOrderButton.click();
    }
}
