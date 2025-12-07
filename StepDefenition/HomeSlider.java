package StepDef;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomeSlider {

    ChromeDriver driver;
    HomePage slider ;

    @BeforeMethod
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        slider = new HomePage(driver);
    }

    @Test
    public void Validate_Nokia_Lumia_1020_Slider() {

        slider.clickSlider("img[src=\"https://demo.nopcommerce.com/images/thumbs/0000079_banner_1.webp\"]",
                "https://demo.nopcommerce.com/nokia-lumia-1020");
    }
    @Test
    public void Validate_iPhone_6_Slider() {
        slider.clickSlider("img[src=\"https://demo.nopcommerce.com/images/thumbs/0000080_banner_2.webp\"]" ,
                "https://demo.nopcommerce.com/iphone-6");
    }
    @AfterMethod
    void close() {
        driver.quit();
    }
}
