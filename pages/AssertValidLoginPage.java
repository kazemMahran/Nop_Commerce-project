package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class AssertValidLoginPage {
    ChromeDriver driver;

    public AssertValidLoginPage (ChromeDriver driver){
        this.driver = driver;
    }

    private By validLoginLoc = By.cssSelector("a[class=\"ico-account\"]");
    private String URL ="https://demo.nopcommerce.com/";

    public void assertValidLogin(){

        Boolean x = driver.getCurrentUrl().contains(URL);
        SoftAssert asert = new SoftAssert();
        asert.assertTrue(x);
        Boolean y = driver.findElement(validLoginLoc).isDisplayed();
        asert.assertTrue(y);
        asert.assertAll();
    }
}
