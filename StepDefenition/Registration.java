package StepDef;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AssertRegPage;
import pages.HomePage;
import pages.RegPage;

public class Registration {

    ChromeDriver driver;
    HomePage HomP;
    RegPage RegP;
    AssertRegPage AssP;

    @BeforeMethod
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        HomP = new HomePage(driver);
        RegP = new RegPage(driver);
        AssP =new AssertRegPage(driver);
    }
    @Test
    public void validRegistration(){

        HomP.clickRegButton();

        RegP.EnterGenderType();
        RegP.EnterValidUserName();
        RegP.EnterValidEmail();
        RegP.EnterCompanyName();
        RegP.clickNewsletter();
        RegP.EnterValidPassword();
        RegP.clickRegister();
        AssP.assertReg();

    }
    @AfterMethod
    void close() {
        driver.quit();
    }
}
