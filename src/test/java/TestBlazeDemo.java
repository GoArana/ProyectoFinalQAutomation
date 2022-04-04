import utility.DriverFactory;
import utility.PropertiesFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;

public class TestBlazeDemo {
    private String url = PropertiesFile.getProperty("url");
    public WebDriver driver = DriverFactory.getDriver();

    DemoHomePage demoCategories;
    DemoProductsPage demoProductsPage;
    DemoProductDetail demoDetailItemPage;
    DemoNavBarPage demoNavBarPage;
    DemoCartPage demoCartPage;
    DemoFormPage demoOrderFormPage;
    DemoConfirmationPage demoConfirmModal;

    String model;
    String price;
    String cartModel;
    String cartPrice;
    String confirmationMessage;
    String expectedMessage;
    String name;
    String country;
    String city;
    String card;
    String month;
    String year;

    @BeforeTest
    public void BeforeTest() {
        driver.get(url);
        driver.navigate().to(url);
        driver.manage().window().maximize();
    }

    @Test
    public void NavigateInDemoBlaze() {
        demoCategories = new DemoHomePage(driver);
        demoProductsPage = new DemoProductsPage(driver);
        demoDetailItemPage = new DemoProductDetail(driver);
        demoNavBarPage = new DemoNavBarPage(driver);
        demoCartPage = new DemoCartPage(driver);
        demoOrderFormPage = new DemoFormPage(driver);
        demoConfirmModal = new DemoConfirmationPage(driver);

        demoCategories.clickOnLaptopsSection();
        demoProductsPage.clickProduct();

        model = demoDetailItemPage.getModel();
        price = demoDetailItemPage.getPrice();

        demoDetailItemPage.clickOnAddToCartButton();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        demoNavBarPage.clickOnCartSection();
        cartModel = demoCartPage.getModel();
        cartPrice = demoCartPage.getPrice();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(model, cartModel);
        softAssert.assertEquals(price, cartPrice);
        softAssert.assertAll();
        demoCartPage.clickOnPlaceOrderButton();

        demoOrderFormPage.fillForm(name = "Gonzalo Arana", country = "Argentina", city = "Bernal",
                card = "3213 4542 3324 5899", month = "November", year = "2022");

        confirmationMessage = DemoConfirmationPage.getConfirmationText();
        expectedMessage = "Thank you for your purchase!";

        Assert.assertEquals(confirmationMessage, expectedMessage);
        Assert.assertTrue(DemoConfirmationPage.getCardConfirmation().contains(name));
        Assert.assertTrue(DemoConfirmationPage.getCardConfirmation().contains(card));
        Assert.assertTrue(DemoConfirmationPage.getCardConfirmation().contains(cartPrice));
    }

    @AfterTest
    public void EndTest() {
        driver.quit();
    }
}