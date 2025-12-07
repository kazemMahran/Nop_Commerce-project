package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AssertSearchPage {

    ChromeDriver driver;

    public AssertSearchPage (ChromeDriver driver){
        this.driver = driver;
    }

    private By itemsLoc = By.cssSelector("div[class=\"item-box\"]");
    private String URL ="https://demo.nopcommerce.com/search?q=";
    private By productLoc = By.cssSelector("div[class=\"product-item\"]");
    private By skuItemLoc = By.cssSelector("div[class=\"sku\"]");

    public void assertWithName(String ProductName) {

        Boolean x = driver.getCurrentUrl().contains(URL);
        SoftAssert asert = new SoftAssert();
        asert.assertTrue(x);

        List<WebElement> elements = driver.findElements(itemsLoc);

        int numSearchResult = elements.size();

        for (int i = 0; i < numSearchResult; i++) {

            Boolean text = elements.get(i).getText().toLowerCase().contains(ProductName);

            asert.assertTrue(text);
        }
        asert.assertAll();
    }
    public void assertWithSKU(String SKU) {

        driver.findElement(productLoc).click();
        Boolean x = driver.findElement(skuItemLoc).getText().contains(SKU);
        Assert.assertTrue(x);
    }
    }
