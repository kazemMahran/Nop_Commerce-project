package StepDef;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AssertRegPage;
import pages.HomePage;

public class Currencies {

    ChromeDriver driver;
    HomePage Euro;

    @BeforeMethod
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        Euro = new HomePage(driver);
    }
    @Test
    public void Verify_Euro_Symbol_Appears () {

        Euro.selectCurrency();
        Euro.assertCurrency();

    }
    @AfterMethod
    void close() {
        driver.quit();
    }


}
