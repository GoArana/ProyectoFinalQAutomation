package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoProductsPage {
    By firstElementModel = By.linkText("Sony vaio i5");
    WebDriver driver;

    public DemoProductsPage(WebDriver driver) {

        this.driver = driver;
    }

    public void clickProduct() {
        driver.findElement(firstElementModel).click();
    }
}
