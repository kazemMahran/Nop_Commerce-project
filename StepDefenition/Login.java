package StepDef;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class Login {

    ChromeDriver driver;
    HomePage Hp;
    LoginPage log ;
    AssertValidLoginPage Assert;

    @BeforeMethod
    void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        log =new LoginPage(driver);
        Assert = new AssertValidLoginPage(driver);
        Hp = new HomePage(driver);
        Hp.clickLoginButton();
    }
    @Test
    public void validLogin(){

        log.login("test5@example.com", "P@ssw0rd");
        Assert.assertValidLogin();
    }
    @Test
    public void inValidLogin(){

        log.login("wrong@example.com","P@ssw0rd");
        log.assertInValidLogin();
    }
    @AfterMethod
    void close()  {
        driver.quit();
    }


}
