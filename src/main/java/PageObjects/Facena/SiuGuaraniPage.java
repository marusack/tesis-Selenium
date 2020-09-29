package PageObjects.Facena;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class SiuGuaraniPage extends HeaderPage {

    @FindBy(xpath = "//input[@id=\"login\"]")
    public WebElement loginBtn;


    public SiuGuaraniPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLoaded(){
    return driver.getCurrentUrl().contains("guarani.exa.unne.edu.ar/g3w/");
    }
}
