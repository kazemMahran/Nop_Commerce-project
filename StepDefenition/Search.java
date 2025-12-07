package StepDef;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class Search {

    ChromeDriver driver;
    HomePage search ;
    AssertSearchPage Assert ;

    @BeforeMethod
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        search = new HomePage(driver);
        Assert = new AssertSearchPage(driver);
    }

    @Test
    public void search_With_Name() {

        String [] product = {"book", "laptop", "nike"};
        for (int i = 0; i < product.length; i++) {

            search.clickSearchButton(product[i]);

            Assert.assertWithName(product[i]);

        }
    }

    @Test
    public void search_With_Product_SKU() {

        String[] product = {"SCI_FAITH", "APPLE_CAM", "SF_PRO_11"};
        for (int i = 0; i < product.length; i++) {

            search.clickSearchButton(product[i]);

            Assert.assertWithSKU(product[i]);
        }
    }
    @AfterMethod
    void close() {
        driver.quit();
    }


}
