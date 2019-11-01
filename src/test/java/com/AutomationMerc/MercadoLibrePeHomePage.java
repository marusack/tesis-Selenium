package com.AutomationMerc;

import PageObjects.MercadoLibre.LoginPage;
import PageObjects.MercadoLibre.MercadoLibreHomePage;
import PageObjects.MercadoLibre.SearchResultPage;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Mercado Libre suite Peru
 */
public class MercadoLibrePeHomePage extends BaseTests {

    private MercadoLibreHomePage mercadoHomePage;

    @BeforeMethod
    public void beforeTest() {
        mercadoHomePage = PageFactory.initElements(driver, MercadoLibreHomePage.class);
        mercadoHomePage.go("http://www.mercadolibre.com.pe");
    }

    /**
     * verifies the prediction module
     */
    @Test(groups = {"mercadolibre", "search engine", "INTER-001"})
    public void searchEnginePrediction_displayed() {
        mercadoHomePage.fillSearch("M");
        Assert.assertTrue("The suggestions for the search is not displayed.", mercadoHomePage.isPredictionDropboxDisplayed());
    }

    /**
     * verifies the engine finds a product searched and redirects to Search result page
     */
    @Test(groups = {"mercadolibre", "search engine", "INTER-001"})
    public void searchEngineSearch_displayed() {
        String searchData = "Mesa";
        SearchResultPage result = mercadoHomePage.makeSearch(searchData);
        Assert.assertTrue("The Search Results Page is not displayed for data: " + searchData + ".", result.titleOfSearch.isDisplayed());
        Assert.assertEquals("The Search data:" + searchData + " does not match the title of the search", searchData.toUpperCase(), result.titleOfSearch.getText().toUpperCase());
        Assert.assertTrue("Products Listed as result of search are not displayed ", result.countRows(driver) > 0);
    }

    /**
     * verifies the tabs visibility
     */
    @Test(groups = {"mercadolibre", "Header", "INTER-002"})
    public void searchEngineTabs_displayed() {
        Assert.assertTrue("The Tab 'Crea tu cuenta' is not displayed", mercadoHomePage.isDisplayed(mercadoHomePage.creaTuCuentaTab));
        Assert.assertTrue("The Tab 'Ingresa' is not displayed", mercadoHomePage.isDisplayed(mercadoHomePage.ingresaTab));
        Assert.assertTrue("The Tab 'Mis compras' is not displayed", mercadoHomePage.isDisplayed(mercadoHomePage.misComprasTab));
    }

    /**
     * verifies the title of the module login
     */
    @Test(groups = {"mercadolibre", "integration", "INTER-002"})
    public void welcomeMessage_displayed() {
        LoginPage login = mercadoHomePage.goToIngresa();
        Assert.assertTrue("Welcome msg is not displayed : ¡Hola! Ingresa tu e‑mail o usuario.", login.isMessageDisplayed(driver,"¡Hola! Ingresa tu e‑mail o usuario"));
        Assert.assertTrue("Email input is not displayed.", login.isDisplayed(login.usernameInput));
        Assert.assertTrue("'Continuar' Button is not displayed.", login.isDisplayed(login.continuarBotton));
        Assert.assertTrue("'Crear cuenta' link is not displayed.", login.isDisplayed(login.linkCrearCuenta));
    }

}
