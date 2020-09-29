package PageObjects.Facena;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DestacadosPage extends HeaderPage {

    @FindBy(css = "//strong[text()=\"Destacados\"]")
    public WebElement boxTitle;

    @FindBy(xpath = "//div[@id=\"column\"]/div/iframe [3]")
    public WebElement contenedor;


    public DestacadosPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getElementByText(String s){
        return driver.findElement(By.xpath("//*[text()=\""+s+"\"]"));
    }
    public SiuGuaraniPage goToSiu(){
        driver.switchTo().frame(5).findElement(By.xpath("//a[text()=\"SIU Guaraní\"]")).click();
        driver.switchTo().defaultContent();
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        return PageFactory.initElements(driver, SiuGuaraniPage.class);
    }
}
