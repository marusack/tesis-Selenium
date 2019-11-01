package com.AutomationMerc;

import PageObjects.MercadoLibre.LoginPage;
import PageObjects.MercadoLibre.MercadoLibreHomePage;
import PageObjects.MercadoLibre.RegistrationPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


/**
 * Mercado Libre suite Peru
 */
public class MercadoLibrePeLogin extends BaseTests {

    private LoginPage loginPage;

    //private final String URL = ;
    @BeforeMethod
    public void beforeTest() {
        MercadoLibreHomePage mercadoHomePage = PageFactory.initElements(driver, MercadoLibreHomePage.class);
        mercadoHomePage.go("http://www.mercadolibre.com.pe");
        loginPage = mercadoHomePage.goToIngresa();
        closePopUp();

    }

    /**
     * to handle regional pop up
     */
    private void closePopUp() {
        if(loginPage.isMessageDisplayed(driver, "¡Estás en Mercado Libre Peru!")){
            driver.findElement(By.cssSelector("a.andes-modal-dialog__button-close")).click();
        }
    }

    /**
     * verifies the element of the form login
     */
    @Test(groups = {"mercadolibre", "Login", "INTER-002"})
    public void LoginForm_displayed() {
        Assert.assertTrue("Welcome msg is not displayed : ¡Hola! Ingresa tu e‑mail o usuario.", loginPage.isMessageDisplayed(driver,"¡Hola! Ingresa tu e‑mail o usuario"));
        Assert.assertTrue("Email input is not displayed.", loginPage.isDisplayed(loginPage.usernameInput));
        Assert.assertTrue("'Continuar' Button is not displayed.", loginPage.isDisplayed(loginPage.continuarBotton));
        Assert.assertTrue("'Crear cuenta' link is not displayed.", loginPage.isDisplayed(loginPage.linkCrearCuenta));
    }

    /**
     * verifies the fuctionality of login form until recaptcha
     * test is not 100% automated because of recaptha
     */
    @Test(groups = {"mercadolibre", "Login", "INTER-002"})
    public void LoginForm_functional() {
        loginPage.fillEmailAndContinue("marianarom51@gmail.com");
        Assert.assertTrue("reCaptcha is not shown", loginPage.isMessageDisplayed(driver,"Completa este paso para continuar."));
    }

    /**
     * verifies the Error message for fiel Email
     */
    @Test(groups = {"mercadolibre", "Login", "INTER-002"})
    public void LoginEmailError() {
        loginPage.fillEmailAndContinue("marianarom51@");
        Assert.assertTrue("Welcome msg is not displayed : Revisa tu e-mail o usuario.", loginPage.isMessageDisplayed(driver,"Revisa tu e-mail o usuario."));
    }

    /**
     * verifies integration to regidtration page
     */
    @Test(groups = {"mercadolibre", "integration", "INTER-002"})
    public void crearCuentaLink_Displayed() {
        RegistrationPage registrationPage = loginPage.goToRegistration(driver);
        Assert.assertTrue("Link 'Crear cuenta' is not redirecting to Registration Page", registrationPage.isMessageDisplayed(driver,"Completa tus datos"));
    }
}
