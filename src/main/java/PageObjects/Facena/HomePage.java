package PageObjects.Facena;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;

public class HomePage extends HeaderPage {

    @FindBy(css = "#content")
    public WebElement conten;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public BibliotecaPage goBibliotecas(){
        this.bibliotecaDrop.click();
        return PageFactory.initElements(driver, BibliotecaPage.class);
    }

    public DestacadosPage goToDestacados() {
       return PageFactory.initElements(driver, DestacadosPage.class);
    }


}
