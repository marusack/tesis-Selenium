package PageObjects.MercadoLibre;

import PageObjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class RegistrationPage extends BasePage {
    @FindBy(css = "#firstName")
    public WebElement nameInput;

    @FindBy(css = "#lastName")
    public WebElement lastnameInput;

    @FindBy(css = "#email")
    public WebElement emailInput;

    @FindBy(css = "#password")
    public WebElement paswordInput;

    @FindBy(xpath = "//button//span[text()=\"Crear cuenta\"]")
    public WebElement sumbitButton;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void fillNomYape(WebDriver driver,String name, String lname) {
        nameInput.clear();
        lastnameInput.clear();
        nameInput.sendKeys(name);
        lastnameInput.sendKeys(lname);
        sumbitButton.click();
    }

    public void fillEmail(WebDriver driver,String s) {
        emailInput.clear();
        emailInput.sendKeys(s);
        sumbitButton.click();
    }

    public void fillPassword(WebDriver driver,String s) {
        paswordInput.clear();
        paswordInput.sendKeys(s);
        sumbitButton.click();
    }

    public void clearAll(WebDriver driver) {
        nameInput.clear();
        lastnameInput.clear();
        emailInput.clear();
        paswordInput.clear();
    }

    public void fillAll(WebDriver driver, String name, String lname, String s, String pass) {
        nameInput.clear();
        lastnameInput.clear();
        nameInput.sendKeys(name);
        lastnameInput.sendKeys(lname);
        emailInput.clear();
        emailInput.sendKeys(s);
        paswordInput.clear();
        paswordInput.sendKeys(pass);
        sumbitButton.click();
    }
}
