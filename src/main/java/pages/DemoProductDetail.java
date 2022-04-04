package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoProductDetail {
    @FindBy(xpath = "//div[@id='tbodyid']/h2")
    WebElement modelDetail;
    @FindBy(xpath = "//div[@id='tbodyid']/h3")
    WebElement priceDetail;
    @FindBy(xpath = "//div[@id='tbodyid']/div[@class='row']/div/a")
    WebElement addToCart;
    WebDriver driver;

    public DemoProductDetail(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getModel() {
        return modelDetail.getText();
    }

    public String getPrice() {
        String price = priceDetail.getText();
        String priceString = price.substring(1, 4);
        return priceString;
    }

    public void clickOnAddToCartButton() {
        addToCart.click();
    }
}
