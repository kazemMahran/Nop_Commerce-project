package StepDef;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AssertLinkPage;
import pages.HomePage;

public class FollowUs {


    ChromeDriver driver;
    AssertLinkPage verifyLink;
    HomePage link;

    @BeforeMethod
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        verifyLink= new AssertLinkPage(driver);
        link = new HomePage(driver);
    }

    @Test
    public void Verify_Facebook_link()   {

        link.clickLink("a[href=\"https://www.facebook.com/nopCommerce\"]");
        verifyLink.AssertLink("https://www.facebook.com/nopCommerce");

    }

    @Test
    public void Verify_Twitter_link() {
        link.clickLink("a[href=\"https://twitter.com/nopCommerce\"]");
        verifyLink.AssertLink("https://x.com/nopCommerce");
    }

    @Test
    public void Verify_RSS_link() {
        link.clickLink("a[href=\"/news/rss/1\"]");
        verifyLink.AssertLink("https://demo.nopcommerce.com/new-online-store-is-open");
    }

    @Test
    public void Verify_YouTube_link() {
        link.clickLink("a[href=\"https://www.youtube.com/user/nopCommerce\"]");
        verifyLink.AssertLink("https://www.youtube.com/user/nopCommerce");
    }

    @AfterMethod
    void close() {
        driver.quit();
    }
}
