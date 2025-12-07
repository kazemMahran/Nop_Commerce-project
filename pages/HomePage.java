package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class HomePage {
    ChromeDriver driver;

    public HomePage(ChromeDriver driver) {
        this.driver = driver;
    }

    private By regButtonLoc = By.className("ico-register");
    private By loginButtonLoc = By.cssSelector("a[class=\"ico-login\"]");
    private By currencyLoc = By.id("customerCurrency");
     By[] listProductLoC = {By.xpath("(//span[@class=\"price actual-price\"])[1]"),
            By.xpath("(//span[@class=\"price actual-price\"])[2]"),
            By.xpath("(//span[@class=\"price actual-price\"])[3]"),
            By.xpath("(//span[@class=\"price actual-price\"])[4]")
    };
    private By searchLoc = By.id("small-searchterms");
    private By clickSearchLoc = By.cssSelector("button[class=\"button-1 search-box-button\"]");
    private By wishButtonLoc = By.xpath("(//button[@class=\"button-2 add-to-wishlist-button\"])[3]");
    private By messageLoc = By.cssSelector("div[class=\"bar-notification success\"]");
    private By wishCartButtonLoc = By.cssSelector("span[class=\"wishlist-qty\"]");
    private By alertLoc = By.cssSelector("div[class=\"bar-notification success\"]");
//Registration
    public void clickRegButton() {
        driver.findElement(regButtonLoc).click();
    }
//Login
    public void clickLoginButton() {
        driver.findElement(loginButtonLoc).click();
    }
//Currencies
    public void selectCurrency() {

        Select sel1 = new Select(driver.findElement(currencyLoc));
        sel1.selectByVisibleText("Euro");
    }

    public void assertCurrency() {

        for (int i = 0; i < listProductLoC.length; i++) {
            Boolean a = driver.findElement(listProductLoC[i]).getText().contains("€");
            Assert.assertTrue(a);
        }
    }
//Search
    public void clickSearchButton(String productName) {

        driver.findElement(searchLoc).sendKeys(productName);
        driver.findElement(clickSearchLoc).click();

    }
//HomeSlider
    public void clickSlider(String sliderLoc, String expectedLink) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector(sliderLoc))).click();

        String actual = driver.getCurrentUrl();
        Assert.assertEquals(actual, expectedLink);
    }
//FollowUs
    public void clickLink (String linkLoc ){

        driver.findElement(By.cssSelector(linkLoc)).click();

    }
//    Wishlist
    public void clickWishItemButton() {

        driver.findElement(wishButtonLoc).click();
    }
    public void clickWisCartButton() {

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.
                invisibilityOfElementLocated(messageLoc));

        driver.findElement(wishCartButtonLoc).click();
    }

    public void assertWishProduct() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        Boolean x = wait.until(ExpectedConditions.visibilityOfElementLocated(alertLoc)).isDisplayed();
        SoftAssert asert = new SoftAssert();
        asert.assertTrue(x);

        String acrual = Color.fromString(driver.findElement(alertLoc)
                .getCssValue("background-color")).asHex();
        asert.assertEquals(acrual, "#4bb07a");
        asert.assertAll();

    }
}
