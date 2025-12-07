package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class LoginPage {
    ChromeDriver driver;
    public LoginPage (ChromeDriver driver){
        this.driver = driver;
    }
    private By emailoc = By.cssSelector("input[class=\"email\"]");
    private By passwordLoc = By.id("Password");
    private By loginloc = By.cssSelector("button[class=\"button-1 login-button\"]");
    private By invalidLoginLoc = By.cssSelector("div[class=\"message-error validation-summary-errors\"]");
    private String massege="Login was unsuccessful.";
    private String color="rgba(228, 67, 75, 1)";
    public void login (String email ,String password ){
        driver.findElement(emailoc).sendKeys(email);
        driver.findElement(passwordLoc).sendKeys(password);
        driver.findElement(loginloc).click();


    }
    public void assertInValidLogin(){

        Boolean x = driver.findElement(invalidLoginLoc).getText().contains(massege);
        SoftAssert asert = new SoftAssert();
        asert.assertTrue(x);
        String actual = driver.findElement(invalidLoginLoc).getCssValue("color");
        String actualColor = Color.fromString(actual).asHex();
        String expectedColor = Color.fromString(color).asHex();
        asert.assertEquals(actualColor,expectedColor);
        asert.assertAll();
    }
}
