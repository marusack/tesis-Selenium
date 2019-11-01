package PageObjects.MercadoLibre;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(css = "input#user_id")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@value= \"Continuar\"]")
    public WebElement continuarBotton;

    @FindBy(css = "a#registration-link")
    public WebElement linkCrearCuenta;

    /**
     * Login Page for Spanish version, Peru platform
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    /**
     * fills the form for login
     * @param s
     */
    public void fillEmail(String s) {
        usernameInput.clear();
        usernameInput.sendKeys(s);
    }

    /**
     * fills the form for login
     * @param s
     */
    public void fillEmailAndContinue(String s) {
        usernameInput.clear();
        usernameInput.sendKeys(s);
        continuarBotton.click();
    }

    public RegistrationPage goToRegistration(WebDriver driver) {
        linkCrearCuenta.click();
        return PageFactory.initElements(driver, RegistrationPage.class);
    }
}
