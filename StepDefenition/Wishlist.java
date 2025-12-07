package StepDef;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.AssertWishlistCartPage;

public class Wishlist {


    ChromeDriver driver;
    HomePage wishitem;
    AssertWishlistCartPage WLCart;


    @BeforeTest
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        wishitem = new HomePage(driver);
        WLCart = new AssertWishlistCartPage(driver);
    }

    @Test
    public void Add_item_to_wishlist() {

        wishitem.clickWishItemButton();
        wishitem.assertWishProduct();

    }

    @Test
    public void Validate_item_appears_in_the_wishlist() {

        wishitem.clickWishItemButton();
        wishitem.clickWisCartButton();
        WLCart.assertNumOfWishItem();
    }

    @AfterTest
    void close() {
        driver.quit();
    }

}
