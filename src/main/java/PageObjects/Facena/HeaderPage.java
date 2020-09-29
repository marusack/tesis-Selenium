package PageObjects.Facena;

import PageObjects.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Arrays;
import java.util.List;

public class HeaderPage extends BasePage {

    @FindBy(css = ".halflings.white.home")
    public WebElement inicioDrop;

    @FindBy(xpath = "//a[text()=\"Institucional\"]")
    public WebElement InstitucionalDrop;

    @FindBy(xpath = "//a[text()=\" Secretarías\"]")
    public WebElement secretariaDrop;

    @FindBy(xpath = "//a[text()=\" Carreras\"]")
    public WebElement carrerasDrop;

    @FindBy(xpath = "//a[text()=\"Docentes\"]")
    public WebElement docentesDrop;

    @FindBy(xpath = "//a[text()=\"Alumnos\"]")
    public WebElement alumnosDrop;

    @FindBy(xpath = "//a[text()=\"Biblioteca\"]")
    public WebElement bibliotecaDrop;

    @FindBy(xpath = "//a[text()=\"Graduados\"]")
    public WebElement gradudadosDrop;

    @FindBy(xpath = "//nav[@id=\"nav-header-menu\"]//a[text()=\"Estudiante\"]")
    public WebElement GestudianteDrop;

    public HeaderPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getOptionsFromWeb(String option) {

        if (option.contains("Institucional")){
            return driver.findElements(By.xpath("//li/a[text()= \"Institucional\"]/following-sibling::ul/li/a"));
        }
        if (option.contains("Secretarías")){
            return driver.findElements(By.xpath("//li/a[text()= \"Secretarías\"]/following-sibling::ul/li/a"));
        }
        if (option.contains("Carreras")){
            return driver.findElements(By.xpath("//li/a[text()= \" Carreras\"]/following-sibling::ul/li/a"));
        }
        if (option.contains("Docentes")){
            return driver.findElements(By.xpath("//li/a[text()= \"Docentes\"]/following-sibling::ul/li/a"));
        }
        if (option.contains("Alumnos")) {
            return driver.findElements(By.xpath("//li/a[text()= \"Alumnos\"]/following-sibling::ul/li/a"));
        }
        if (option.contains("Biblioteca")){
            return driver.findElements(By.xpath("//li/a[text()= \"Biblioteca\"]/following-sibling::ul/li/a"));
        }
        if (option.contains("Graduados")){
            return driver.findElements(By.xpath("//li/a[text()= \"Graduados\"]/following-sibling::ul/li/a"));
        }
        if (option.contains("Estudiante")){
            return driver.findElements(By.xpath("//li/a[text()= \"Estudiante\"]/following-sibling::ul/li/a"));
        }
        return null;
    }


    public List<String> getOptionsFromBD(String option) {
        List<String> baseOptions = null;

        if (option.contains("Institucional")){
            baseOptions = Arrays.asList(" Autoridades","Normativas"," Historia","Decanato","Memorias Institucionales ");
        }
        if (option.contains("Secretarías")){
            baseOptions = Arrays.asList("Académica", "Administrativa", "Asuntos Estudiantiles", "Extensión", "Investigación y Postgrado");
        }
        if (option.contains("Carreras")){
            baseOptions = Arrays.asList("Directores","Carreras de Grado","Carreras de Pre-Grado","Extensiones Áulicas","Programa de Ofertas Educativas Especiales (POEE)");
        }
        if (option.contains("Docentes")){
            baseOptions = Arrays.asList("Agrimensura","Biología","Bioquímica","Física","Humanidades","Informática","Ingeniería","Matemática","Química");
        }
        if("Alumnos".contains(option)){
            baseOptions = Arrays.asList("Ingresantes y Recursantes 1° AÑO","Becas","Intercambio Estudiantil","Servicios Sociales","Reglamentaciones","Guía de Trámites","Trámites Resueltos","Centro de Estudiantes","Readmisiones y Excepciones","Instructivo SIU-Guarani: Perfil Alumno");
        }
        if (option.contains("Estudiante")){
            baseOptions = Arrays.asList("GabinetePsicopedagógico","Tutorìas FaCENA");
        }
        return baseOptions;
    }

    public boolean isIntructivoDisplayed() {
        //para ver esto home debe estar en la pantalla de instructivo siu
        return driver.findElement(By.xpath("//a[@href=\"docs/Perfil_Alumno.pdf\"]")).isDisplayed();
    }

    public void goToInstructivo() {
        goHoverByXpath("//a[text()=\"Alumnos\"]");
        driver.findElement(By.xpath("//a[@href=\"../../alumnos/instructivosiu.php\"]")).click();
    }

    public void goToPageFromNav(String titulo) {
        goHoverByXpath("//a[text()=\""+ titulo +"\"]");
        driver.findElement(By.xpath("//a[text()=\""+ titulo +"\"]")).click();
    }

    public List<String> getNavOptionsFromBD() {
        List<String> baseOptions = Arrays.asList(" Inicio","Institucional"," Secretarías"," Carreras","Alumnos","Biblioteca","Graduados","Estudiante");
        return baseOptions;
    }
}
