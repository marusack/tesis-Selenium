package com.Facena;

import PageObjects.Facena.*;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.AssertLog;

import java.util.List;


/**
 * Mercado Libre suite Peru
 */
public class FacenaTest extends BaseTests {

    private HomePage home;
    private String regex = "^(http:\\/\\/exa.unne.edu.ar)(\\/[a-z0-9]*)?\\/([a-z0-9]*).(php)";

    @BeforeMethod
    public void beforeTest() {
        home = PageFactory.initElements(driver, HomePage.class);
        driver.get("http://exa.unne.edu.ar/");
    }


    /**
     * Dado que soy alumno de la facultad,
     * Cuando accedo a la sección de bibliotecas,
     * Entonces debo de visualizar todos los accesos virtuales (redirreciones)
     * a contenido proveído por la Facultad
     */
    @Test(groups = {"facena", "", "story-001"})
    public void historia1_test1() {
        AssertLog.assertTrue(home.bibliotecaDrop.isDisplayed(), "La opcion Biblioteca se encuentra desplegada");
        BibliotecaPage bibliotecaPage = home.goBibliotecas();
        AssertLog.assertTrue(bibliotecaPage.isEnlacesDeInteresDisplayed(), "Los enlaces de Interes se encuentran visibles");
    }

    /**
     * Dado que ingreso a la sección de biblioteca y selecciono el link de Revista FaCENA,
     * Cuando selecciono el link,
     * Entonces el sistema redirige a la página oficial de Revista FaCENA con la URL: http://exa.unne.edu.ar/revisfacena/.
     */
    @Test(groups = {"facena", "", "story-001"})
    public void historia1_test2() {
       AssertLog.assertTrue(home.bibliotecaDrop.isDisplayed(), "La opcion Biblioteca se encuentra desplegada y visible");
        BibliotecaPage bibliotecaPage = home.goBibliotecas();
       AssertLog.assertTrue(bibliotecaPage.getRevistaURL().contains("http://exa.unne.edu.ar/revisfacena/"), "El link de revista facena sigue formato http://exa.unne.edu.ar/revisfacena/");
    }

    /**
     * Dado que ingreso a la sección de biblioteca y selecciono el link de Formulario de consulta, Cuando selecciono el
     * link “Formulario”, Entonces el sistema redirige al formulario de consulta
     * con la Url inicial https://docs.google.com/forms/...
     */
    @Test(groups = {"facena", "", "story-001"})
    public void historia1_test3() throws InterruptedException {
        AssertLog.assertTrue(home.bibliotecaDrop.isDisplayed(), "La opcion Biblioteca se encuentra desplegada y visible");
        BibliotecaPage bibliotecaPage = home.goBibliotecas();
        AssertLog.assertTrue(bibliotecaPage.isLoaded(), "La pagina de Biblioteca se cargo correctamente.");
        Formulario formulario = bibliotecaPage.goToFormulario();
        AssertLog.assertTrue(formulario.isLoaded(), "La Pagina de Formulario de Red de bibliotecas se encuentra visible, el texto 'FORMULARIO DE CONSULTA VIRTUAL' es visible");
        resetDriverForTabs();
    }

    /**
     *Dado que ingreso a la Página de Inicio de la FaCENA, Cuando la página termina de cargar, Entonces debo de poder
     * visualizar la página de destacados con las opciones
     */
    @Test(groups = {"facena", "", "story-001"})
    public void historia2_test4() throws InterruptedException {
        AssertLog.assertTrue(home.bibliotecaDrop.isDisplayed(), "La Pagina de Home se encuentra desplegada y visible");
        DestacadosPage destacados = home.goToDestacados();
        AssertLog.assertTrue(destacados.contenedor.isDisplayed(), "El modulo de Destacados se encuentra desplegada y visible");
        // limitaciones en la codificacion previenen el testing de las opciones por el uso de frames

        }

    /**
     *Dado que estoy en el módulo de Destacados de la página principal Cuando selecciono el link “SIU Guarani”,
     * Entonces se direcciona a la url https://guarani.exa.unne.edu.ar/g3w/
     */
    @Test(groups = {"facena", "", "story-001"})
    public void historia2_test5() throws InterruptedException {
        AssertLog.assertTrue(home.bibliotecaDrop.isDisplayed(), "La Pagina de Home se encuentra desplegada y visible");
        DestacadosPage destacado = home.goToDestacados();
        SiuGuaraniPage siu = destacado.goToSiu();
        AssertLog.assertTrue(siu.isLoaded(), "El SIU guarani se encuentra desplegada y visible");
        resetDriverForTabs();
    }

    /**
     *Dado que ingreso a través del menú del plegable “Alumnos”, Cuando selecciono la opción “Instructivo SIU Guarani:
     * Perfil de alumno”, Entonces  se debe desplegar la pantalla de información para descargar el Archivo PDF bajo la
     * ruta http://exa.unne.edu.ar/alumnos/docs/Perfil_Alumno.pdf
     */
    @Test(groups = {"facena", "", "story-001"})
    public void historia2_test6() throws InterruptedException {
        AssertLog.assertTrue(home.alumnosDrop.isDisplayed(), "La Pagina de Home se encuentra desplegada y visible");
        List<WebElement> options = home.getOptionsFromWeb("Alumnos");
        home.goToInstructivo();
        AssertLog.assertTrue(home.isIntructivoDisplayed(), "El link al pdf instructivo se encuentra visible");
    }

    /**
     *Dado que soy un alumno regular de FaCENA, Cuando ingreso a cualquier pantalla del menú de navegación,
     * Entonces se debe de mostrar el módulo de destacados en cada uno.
     */
    @Test(groups = {"facena", "", "story-001"})
    public void historia2_test7() throws InterruptedException {
        AssertLog.assertTrue(home.bibliotecaDrop.isDisplayed(), "La Pagina de Home se encuentra desplegada y visible");
        List<String> options = home.getNavOptionsFromBD();
        for (String option: options) {
            home.goToPageFromNav(option);
            AssertLog.assertTrue(home.isMessageDisplayed(driver,"Destacados"), "El modulo Destacados se encuentra desplagado en la pagina "+ option);

        }

    }

    /**
     * Dado que soy un alumno regular de FaCENA, Cuando selecciono el menú <opción>, Entonces debo ser
     *    redirigido a la URL del formato http://exa.unne.edu.ar/<opcion>/<nombre_archivo>.php.
     */
    @Test(groups = {"facena", "", "story-001"})
    public void historia3_test8() throws InterruptedException {
        AssertLog.assertTrue(home.bibliotecaDrop.isDisplayed(), "La Pagina de Home se encuentra desplegada y visible");
        List<String> options = home.getNavOptionsFromBD();
        for (String option: options) {
            home.goToPageFromNav(option);
            AssertLog.assertTrue(driver.getCurrentUrl().toString().matches(regex), "La seccion corresponde con la URL "+driver.getCurrentUrl().toString()+" para la opcion de nav: "+ option);

        }
    }

    /**
     *Dado que soy un alumno regular de FaCENA, Cuando selecciono la opción de menú “Institucional”,
     * Entonces se deben desplegar las opciones Autoridades, Normativas, Historia, Decanato
     */
    @Test(groups = {"facena", "", "story-001"})
    public void historia3_test9() throws InterruptedException {
        AssertLog.assertTrue(home.bibliotecaDrop.isDisplayed(), "La Pagina de Home se encuentra desplegada y visible");
        List<WebElement> options = home.getOptionsFromWeb("Institucional");
        List<String> baseList = home.getOptionsFromBD("Institucional");
        System.out.println("La lista de BD :"+ baseList);
        for (WebElement option: options) {
            String title =option.getAttribute("text");
            System.out.println("La opcion con nombre :"+ title);
            AssertLog.assertTrue(baseList.contains(title), "La opcion del menu  Institucional se encuentra desplegada correctamente y coincide con esperado por BD");
        }
    }
    /**
     *Dado que soy un alumno regular de FaCENA, Cuando selecciono la opción de menú “Secretarías”, Entonces se
     * deben desplegar las opciones: Académica, Administrativa, Asuntos Estudiantiles, Extensión, Investigación y Postgrado
     */
    @Test(groups = {"facena", "", "story-001"})
    public void historia3_test10() throws InterruptedException {
        AssertLog.assertTrue(home.bibliotecaDrop.isDisplayed(), "La Pagina de Home se encuentra desplegada y visible");
        List<WebElement> options = home.getOptionsFromWeb("Secretarías");
        List<String> baseList = home.getOptionsFromBD("Secretarías");
        System.out.println("La lista de BD :"+ baseList);
        for (WebElement option: options) {
            String title =option.getAttribute("text");
            System.out.println("La opcion con nombre :"+ title);
            AssertLog.assertTrue(baseList.contains(title), "La opcion del menu  Secretarías se encuentra desplegada correctamente y coincide con esperado por BD");
        }
    }

    /**
     * Dado que soy un alumno regular de FaCENA, Cuando selecciono la opción de menú “Departamentos”,
     * Entonces se deben desplegar las opciones: Directores, Agrimensura, Biología, Física, Humanidades, informática,
     * Ingeniería, Matemática y Química
     */
    @Test(enabled = false)
    public void historia3_test11() throws InterruptedException {
        AssertLog.assertTrue(home.bibliotecaDrop.isDisplayed(), "La Pagina de Home se encuentra desplegada y visible");
        List<WebElement> options = home.getOptionsFromWeb("Departamentos");
    }
    /**
     * Dado que soy un alumno regular de FaCENA, Cuando selecciono la opción de menú “Carreras”, Entonces se deben
     * desplegar las opciones: Directores, Carreras de Grado, Carreras de Pre-Grado, Extensiones Áulicas, Programa
     */
    @Test(groups = {"facena", "", "story-001"})
    public void historia3_test12() throws InterruptedException {
        AssertLog.assertTrue(home.bibliotecaDrop.isDisplayed(), "La Pagina de Home se encuentra desplegada y visible");
        List<WebElement> options = home.getOptionsFromWeb("Carreras");
        List<String> baseList = home.getOptionsFromBD("Carreras");
        System.out.println("La lista de BD :"+ baseList);
        for (WebElement option: options) {
            String title =option.getAttribute("text");
            System.out.println("La opcion con nombre :"+ title);
            AssertLog.assertTrue(baseList.contains(title), "La opcion del menu  Carreras se encuentra desplegada correctamente y coincide con esperado por BD");
        }
    }

    /**
     *Dado que soy un alumno regular de FaCENA, Cuando selecciono la opción de menú “Docentes”, Entonces se
     * deben desplegar las opciones: Agrimensura, Biología Bioquímica, Física, Humanidades, informática,
     * ingeniería, Matemáticas, y Química.
     */
    @Test(groups = {"facena", "", "story-001"})
    public void historia3_test13() throws InterruptedException {
        AssertLog.assertTrue(home.bibliotecaDrop.isDisplayed(), "La Pagina de Home se encuentra desplegada y visible");
        List<WebElement> options = home.getOptionsFromWeb("Docentes");
        List<String> baseList = home.getOptionsFromBD("Docentes");
        System.out.println("La lista de BD :"+ baseList);
        for (WebElement option: options) {
            String title =option.getAttribute("text");
            System.out.println("La opcion con nombre :"+ title);
            AssertLog.assertTrue(baseList.contains(title), "La opcion del menu  Docentes se encuentra desplegada correctamente y coincide con esperado por BD");
        }
    }
    /**
     *Dado que soy un alumno regular de FaCENA, Cuando selecciono la opción de menú “Alumnos”, Entonces se deben
     * desplegar las opciones: Ingresantes y Recusantes 1° AÑO, Becas, Intercambio Estudiantil, Servicios Sociales,
     * Reglamentaciones, Guía de Tramites, Tramites Resueltos, Centro de Estudiantes, Readmisiones y Excepciones,
     * Instructivo SIU-Guaraní: Perfil Alumno.
     */
    @Test(groups = {"facena", "", "story-003"})
    public void historia3_test14() throws InterruptedException {
        AssertLog.assertTrue(home.bibliotecaDrop.isDisplayed(), "La Pagina de Home se encuentra desplegada y visible");
        List<WebElement> options = home.getOptionsFromWeb("Alumnos");
        List<String> baseList = home.getOptionsFromBD("Alumnos");
        System.out.println("La lista de BD :"+ baseList);
        for (WebElement option: options) {
            String title =option.getAttribute("text");
            System.out.println("La opcion con nombre :"+ title);
            AssertLog.assertTrue(baseList.contains(title), "La opcion del menu Alumnos se encuentra desplegada correctamente y coincide con esperado por BD");
        }
    }

    /**
     *Dado que soy un alumno regular de FaCENA, Cuando selecciono la opción de menú “Estudiante”,
     * Entonces se deben desplegar las opciones: Gabinete Psicopedagógico y Tutorías FaCENA.. .
     */
    @Test(groups = {"facena", "", "story-003"})
    public void historia3_test15() throws InterruptedException {
        AssertLog.assertTrue(home.bibliotecaDrop.isDisplayed(), "La Pagina de Home se encuentra desplegada y visible");
        List<WebElement> options = home.getOptionsFromWeb("Estudiante");
        List<String> baseList = home.getOptionsFromBD("Estudiante");
        System.out.println("La lista de BD :"+ baseList);
        for (WebElement option: options) {
            String title =option.getAttribute("text");
            System.out.println("La opcion con nombre :"+ title);
            AssertLog.assertTrue(baseList.contains(title), "La opcion del menu Estudiante se encuentra desplegada correctamente y coincide con esperado por BD");
        }
}
}
