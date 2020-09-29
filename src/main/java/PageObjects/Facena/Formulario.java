package PageObjects.Facena;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Formulario extends HeaderPage {


    @FindBy(xpath = "//div[@class=\"freebirdFormeditorViewPageTitleInputContainer\"]")
    public WebElement titulo;

    public Formulario(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded() {
        return titulo.isDisplayed();
    }
}
