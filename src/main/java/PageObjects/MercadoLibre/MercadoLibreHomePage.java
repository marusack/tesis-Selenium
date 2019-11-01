package PageObjects.MercadoLibre;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MercadoLibreHomePage extends BasePage {

    @FindBy(css = "form.nav-search> input")
    public WebElement searchInput;

    @FindBy(css = "button.nav-search-btn")
    public WebElement searchButton;

    @FindBy(xpath = "//nav[@id=\"nav-header-menu\"]//a[text()=\"Crea tu cuenta\"]")
    public WebElement creaTuCuentaTab;

    @FindBy(xpath = "//nav[@id=\"nav-header-menu\"]//a[text()=\"Ingresa\"]")
    public WebElement ingresaTab;

    @FindBy(xpath = "//nav[@id=\"nav-header-menu\"]//a[text()=\"Mis compras\"]")
    public WebElement misComprasTab;


    /**
     * HomePage Spanish version for Peru Platform
     *
     * @param driver
     */
    public MercadoLibreHomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Clicks on tab Crea tu Cuenta, redirects to RegistrationPage
     *
     * @return RegistrationPage
     */
    public RegistrationPage goToCreaTuCuenta() {
        creaTuCuentaTab.click();
        return PageFactory.initElements(super.driver, RegistrationPage.class);
    }

    /**
     * Clicks on tab Ingresa, redirects to Login Page
     *
     * @return Login
     */
    public LoginPage goToIngresa() {
        ingresaTab.click();
        return PageFactory.initElements(super.driver, LoginPage.class);
    }

    /**
     * writes search
     */
    public void fillSearch(String data) {
        searchInput.clear();
        searchInput.sendKeys(data);
    }

    /**
     * makes a full search without prediction
     */
    public SearchResultPage makeSearch(String data) {
        searchInput.clear();
        searchInput.sendKeys(data);
        searchButton.click();
        return PageFactory.initElements(super.driver, SearchResultPage.class);

    }

    public boolean isPredictionDropboxDisplayed() {
        clickJs(searchInput);
        String locator = "//div[contains(@class,\"sb-suggestions__wrapper\")]";
        waitToBeVisible(By.xpath(locator));
        return driver.findElement(By.xpath(locator)).isDisplayed();
    }

}
