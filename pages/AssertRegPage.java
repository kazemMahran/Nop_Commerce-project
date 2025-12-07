package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class AssertRegPage {
    ChromeDriver driver;

    public AssertRegPage(ChromeDriver driver){
        this.driver = driver;
    }

    private By regMassegeLoc = By.className("result");
    private String massege="Your registration completed";
    private String color="rgba(76, 177, 124, 1)";

    public void assertReg(){

        Boolean x = driver.findElement(regMassegeLoc).getText().contains(massege);
        SoftAssert asert = new SoftAssert();
        asert.assertTrue(x);
        Boolean y = driver.findElement(regMassegeLoc).getCssValue("color").contains(color);
        asert.assertTrue(y);
        asert.assertAll();
    }

    }

