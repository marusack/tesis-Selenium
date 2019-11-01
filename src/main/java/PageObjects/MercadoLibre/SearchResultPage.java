package PageObjects.MercadoLibre;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends MercadoLibreHomePage {
    @FindBy(css = "h1.breadcrumb__title")
    public WebElement titleOfSearch;

    @FindBy(css = "div.rowItem")
    public List<WebElement> rowItem;

    /**
     * Search Result Page Spanish version for Peru Platform
     *
     * @param driver
     */
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public int countRows(WebDriver driver){
        return driver.findElements(By.cssSelector("div.rowItem")).size();
    }
}
