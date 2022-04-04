package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoHomePage {
    By laptopsSection = By.xpath("(//a[@id='itemc'])[2]");
    WebDriver driver;

    public DemoHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnLaptopsSection() {
        driver.findElement(laptopsSection).click();
    }

}
