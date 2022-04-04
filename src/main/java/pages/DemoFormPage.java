package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoFormPage {
    By inputName = By.xpath("//input[@id='name']");
    By inputCountry = By.xpath("//input[@id='country']");
    By inputCity = By.xpath("//input[@id='city']");
    By inputCard = By.xpath("//input[@id='card']");
    By inputMonth = By.xpath("//input[@id='month']");
    By inputYear = By.xpath("//input[@id='year']");
    By purchaseButton = By.xpath("//div[@id='orderModal']/div/div/div[@class='modal-footer']/button[2]");
    static WebDriver driver;

    public DemoFormPage(WebDriver driver) {
        DemoFormPage.driver = driver;
    }

    public String setName(String clientName) {
        driver.findElement(inputName).sendKeys(clientName);
        return clientName;
    }

    public String setCountry(String country) {
        driver.findElement(inputCountry).sendKeys(country);
        return country;
    }

    public String setCity(String city) {
        driver.findElement(inputCity).sendKeys(city);
        return city;
    }

    public String setCard(String card) {
        driver.findElement(inputCard).sendKeys(card);
        return card;
    }

    public String setMonth(String month) {
        driver.findElement(inputMonth).sendKeys(month);
        return month;
    }

    public String setYear(String year) {
        driver.findElement(inputYear).sendKeys(year);
        return year;
    }

    public void clickOnPurchaseButton() {
        driver.findElement(purchaseButton).click();
    }

    public void fillForm(String name, String country, String city, String card, String month, String year) {
        setName(name);
        setCountry(country);
        setCity(city);
        setCard(card);
        setMonth(month);
        setYear(year);
        clickOnPurchaseButton();
    }
}
