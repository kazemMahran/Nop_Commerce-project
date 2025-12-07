package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class AssertWishlistCartPage {

    ChromeDriver driver;

    public AssertWishlistCartPage(ChromeDriver driver) {
        this.driver = driver;
    }

    private By quantityLoc = By.cssSelector("td>input[type=\"text\"]");

    public void assertNumOfWishItem() {

        String actual = driver.findElement(quantityLoc).getAttribute("value");
//        System.out.println(actual);
        SoftAssert asert = new SoftAssert();
        asert.assertEquals(actual, "2");
        asert.assertAll();
         }
}
