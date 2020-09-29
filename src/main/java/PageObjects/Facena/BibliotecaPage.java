package PageObjects.Facena;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Collection;

public class BibliotecaPage extends HeaderPage {

    @FindBy(xpath = "//div/strong[text()=\"ENLACES DE INTERES\"]/following::blockquote/p/a[@class=\"textgris\"]")
    public WebElement enlacesDeInteres;

    @FindBy(xpath = "//a[text()= \"Revista FaCENA\"]")
    public WebElement linkRevistaFacena;

    @FindBy(xpath = "//a[text()= \" FORMULARIO\"]")
    public WebElement linkFormulario;


    public BibliotecaPage(WebDriver driver) {
        super(driver);
    }

    public boolean isEnlacesDeInteresDisplayed() {
        return this.enlacesDeInteres.isDisplayed();
    }

    public String getRevistaURL() {
        return this.linkRevistaFacena.getAttribute("href");
    }

    public Formulario goToFormulario() {
        this.linkFormulario.click();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return PageFactory.initElements(driver, Formulario.class);
    }

    public boolean isLoaded() {
        return this.linkFormulario.isDisplayed();
    }
}
