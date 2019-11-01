package com.AutomationMerc;

import PageObjects.MercadoLibre.MercadoLibreHomePage;
import PageObjects.MercadoLibre.RegistrationPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Mercado Libre suite Peru Registration suite - spanish
 */
public class MercadoLibrePeRegistration extends BaseTests {

    private RegistrationPage regPage;

    //private final String URL = ;
    @BeforeMethod
    public void beforeTest() {
        MercadoLibreHomePage mercadoHomePage = PageFactory.initElements(driver, MercadoLibreHomePage.class);
        mercadoHomePage.go("http://www.mercadolibre.com.pe");
        regPage = mercadoHomePage.goToCreaTuCuenta();
        closePopUp(driver);

    }

    /**
     * to handle regional pop up
     */
    private void closePopUp(WebDriver driver) {
        driver.switchTo().defaultContent();
        if (driver.findElement(By.cssSelector("div.andes-modal-dialog__container")).isDisplayed()) {
            driver.findElement(By.cssSelector("div.andes-modal-dialog__container")).findElement(By.cssSelector(".andes-modal-dialog__button-close")).click();
        }
    }

    /**
     * Verifies form for registration
     */
    @Test(groups = {"mercadolibre", "Registration", "INTER-002"})
    public void regForm_displayed() {
        Assert.assertTrue("Welcome msg is not displayed : Completa tus datos.", regPage.isMessageDisplayed(driver, "Completa tus datos"));
        Assert.assertTrue("Input Name 'Nombre' is not displayed ", regPage.isDisplayed(regPage.nameInput));
        Assert.assertTrue("Input Lastname 'Apellido' is not displayed ", regPage.isDisplayed(regPage.lastnameInput));
        Assert.assertTrue("Input Email 'E-mail' is not displayed ", regPage.isDisplayed(regPage.emailInput));
        Assert.assertTrue("Input Password 'Clave' is not displayed ", regPage.isDisplayed(regPage.paswordInput));

    }

    /**
     * Verifies form for registration with number by name and empty data
     */
    @Test(groups = {"mercadolibre", "Registration", "INTER-002"})
    public void messageErrorNombreYapellido_displayed() {
        try {
            regPage.fillNomYape(driver, "1", "2");
            Assert.assertTrue("Error Mesage is not displayed : Ingresa un mínimo de 2 caracteres.", regPage.isMessageDisplayed(driver, "Ingresa un mínimo de 2 caracteres.") ||
                    regPage.isMessageDisplayed(driver, "Usa también letras."));
        } catch (ElementClickInterceptedException e) {
            closePopUp(driver);
        }

    }

    /**
     * Verifies form for registration with empty data
     */
    @Test(groups = {"mercadolibre", "Registration", "INTER-002"})
    public void messageErrorEmptyData_displayed() {
        try {
            regPage.fillNomYape(driver, "", "");
            Assert.assertTrue("Error Mesage is not displayed : Usa solo números y letras. o Ingresa un mínimo de 2 caracteres.", regPage.isMessageDisplayed(driver, "Usa solo números y letras.") ||
                    regPage.isMessageDisplayed(driver, "Ingresa un mínimo de 2 caracteres."));
        } catch (ElementClickInterceptedException e) {
            closePopUp(driver);
        }
    }


    /**
     * Verifies form for registration with empty data
     */
    @Test(groups = {"mercadolibre", "Registration", "INTER-002"})
    public void messageErrorNameLength_displayed() {
        try {
            regPage.fillNomYape(driver, "c", "c");
            Assert.assertTrue("Error Mesage is not displayed : Ingresa un mínimo de 2 caracteres.", regPage.isMessageDisplayed(driver, "Ingresa un mínimo de 2 caracteres."));

        } catch (
                ElementClickInterceptedException e) {
            closePopUp(driver);
        }
    }

    /**
     * Verifies form for registration with empty data
     */
    @Test(groups = {"mercadolibre", "Registration", "INTER-002"})
    public void messageErrorEmailFormat_displayed() {
        try {
            regPage.fillEmail(driver, "maru@s");
            Assert.assertTrue("Error Mesage is not displayed : Usa el formato nombre@ejemplo.com.", regPage.isMessageDisplayed(driver, "Usa el formato nombre@ejemplo.com."));
        } catch (ElementClickInterceptedException e) {
            closePopUp(driver);
        }
    }

    /**
     * Verifies form for registration with empty data
     */
    @Test(groups = {"mercadolibre", "Registration", "INTER-002"})
    public void messageErrorEPassword_displayed() {
        try {
            regPage.fillAll(driver, "mariel", "sack", "maru@dom.com", "1");
            regPage.sumbitButton.click();
            Assert.assertTrue("Error Mesage is not displayed : Completa este dato o La clave no puede tener caracteres correlativos.", regPage.isMessageDisplayed(driver, "Completa este dato.") ||
                    regPage.isMessageDisplayed(driver, "La clave no puede tener caracteres correlativos."));
        } catch (ElementClickInterceptedException e) {
            closePopUp(driver);
        }
    }
}
