package pages;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class AssertLinkPage {
    ChromeDriver driver;

    public AssertLinkPage(ChromeDriver driver) {
        this.driver = driver;
    }

    public void AssertLink (String linkAssert){

        String originalWindow = driver.getWindowHandle();

        for (String windowHandle: driver.getWindowHandles()){
            if (!windowHandle.equals(originalWindow));
            driver.switchTo().window(windowHandle);
        }
        String actual = driver.getCurrentUrl();
        SoftAssert asert = new SoftAssert();
        asert.assertEquals(actual,linkAssert);
        asert.assertAll();
//        Assert.assertTrue(x);

        driver.switchTo().window(originalWindow);
    }


}
