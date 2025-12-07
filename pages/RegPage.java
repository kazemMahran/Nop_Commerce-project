package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegPage {

    ChromeDriver driver;
    public RegPage(ChromeDriver driver){
        this.driver = driver;
    }
    private String firstName="automation";
    private String lasttName="tester";
    private String email="test@example.com";
    private String companyName="Amazon";
    private String password="P@ssw0rd";
    private String confirmPassword="P@ssw0rd";

    private By genderLoc = By.id("gender-male");
    private By fristNameLoc = By.id("FirstName");
    private By lasteNameLOC = By.id("LastName");
    private By emailoc = By.id("Email");
    private By companyloc = By.id("Company");
    private By newsletterLoc = By.id("Newsletter");
    private By passwordLoc = By.id("Password");
    private By confPasswordLoc = By.id("ConfirmPassword");
    private By registerLoc = By.id("register-button");


    public void EnterGenderType(){
        driver.findElement(genderLoc).click();

    }
    public void EnterValidUserName(){
        driver.findElement(fristNameLoc).sendKeys(firstName);
        driver.findElement(lasteNameLOC).sendKeys(lasttName);

    }

    public void EnterValidEmail(){
        driver.findElement(emailoc).sendKeys(email);

    }
    public void EnterCompanyName(){
        driver.findElement(companyloc).sendKeys(companyName);

    }
    public void clickNewsletter(){
        driver.findElement(newsletterLoc).click();

    }
    public void EnterValidPassword() {
        driver.findElement(passwordLoc).sendKeys(password);
        driver.findElement(confPasswordLoc).sendKeys(confirmPassword);
    }
    public void clickRegister(){
        driver.findElement(registerLoc).click();

    }
}
