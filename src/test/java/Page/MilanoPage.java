package Page;

import Utiles.Utilities;
import drivers.DriverContext;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MilanoPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public MilanoPage() {
        PageFactory.initElements(DriverContext.getDriver(), this);
    }

    @FindBy(xpath = "//input[@type=\"email\"]")
    public WebElement inusuario;
    @FindBy(xpath = "//input[@type=\"password\"]")
    public WebElement incontrasena;
    @FindBy(xpath = "//button[@class='btn btn-primary w-100']")
    public WebElement btnEntrar;
    @FindBy(xpath = "//div[@class=\"nav-submenu-title ng-tns-c23-0\"]")
    public WebElement btnAlumno;
    @FindBy(xpath = "//a[@href=\"/alumnos/admin/agregar\"]")
    public WebElement btnAgregarAlumno;
    //inicio sesion ^------------------------------------------
    @FindBy(xpath = "//input[@formcontrolname=\"name\"]")
    public WebElement name;
    @FindBy(xpath = "//input[@formcontrolname=\"lastname\"]")
    public WebElement apellido;
    @FindBy(xpath = "//input[@formcontrolname=\"age\"]")
    public WebElement edad;
    @FindBy(xpath = "//input[@formcontrolname=\"idcard\"]")
    public WebElement rut;
    @FindBy(xpath = "//input[@formcontrolname=\"passport\"]")
    public WebElement pasaporte;
    @FindBy(xpath = "//select[@formcontrolname=\"gender\"]")
    public WebElement sex;
    @FindBy(xpath = "//select[@formcontrolname=\"executive\"]")
    public WebElement ejecutivo;
    @FindBy(xpath = "//input[@formcontrolname=\"phone1\"]")
    public WebElement num;
    @FindBy(xpath = "//input[@formcontrolname=\"email\"]")
    public WebElement email;
    @FindBy(xpath = "//input[@formcontrolname=\"interviewdate\"]")
    public WebElement entrevista;
    @FindBy(xpath = "//input[@formcontrolname=\"address\"]")
    public WebElement direccion;
    @FindBy(xpath = "//input[@formcontrolname=\"city\"]")
    public WebElement ciudad;
    @FindBy(xpath = "//input[@formcontrolname=\"locality\"]")
    public WebElement comuna;
    //----------------------------------------------------------
    @FindBy(xpath = "//input[@formcontrolname=\"representativefullname\"]")
    public WebElement nomApoderado;
    @FindBy(xpath = "//input[@formcontrolname=\"representativephone\"]")
    public WebElement numApoderado;
    @FindBy(xpath = "//input[@formcontrolname=\"representativeemail\"]")
    public WebElement emailApoderado;
    //---------------------------------------------------------------
    @FindBy(xpath = "//select[@formcontrolname=\"type_course\"]")
    public WebElement cursoTipo;
    @FindBy(xpath = "//input[@formcontrolname=\"startCourse\"]")
    public WebElement cursoInicio;
    @FindBy(xpath = "//input[@formcontrolname=\"duration\"]")
    public WebElement cursoDuracion;
    @FindBy(xpath = "//ng-select//input")
    public WebElement curso;
    @FindBy(xpath = "//button[contains(text(),'Agregar Alumno')]")
    public WebElement btnAlumnoAgregado;
    @FindBy(xpath = "//a[@class='btn btn-success']")
    public WebElement btnAgregarAlumnoNuevo;
    @FindBy(xpath =  "//button[@class=\"swal2-confirm swal2-styled\"]")
    public WebElement btnOkAlert;
    @FindBy(xpath = "//span[contains(text(),'Lista de alumnos')]")
    public WebElement btnListaAlumnos;
    @FindBy(xpath = "//*[contains(text(),'Agregar Alumno')]")
    public WebElement btnAgregarAlumno2;
    @FindBy(xpath = "//div[@class='swal2-html-container']")
    public WebElement mensajeModal;
    @FindBy(xpath = "//input[@placeholder=\"Buscar alumnos\"]")
    public WebElement inBuscarRun;
    @FindBy(xpath = "//tbody/tr")
    public WebElement tabla;
    //---------------------------------------------------------------------
    @FindBy(xpath = "//div[@role='dialog']")
    private WebElement mensajeElement;
    @FindBy(xpath = "//div[contains(text(),'Datos insertados correctamente')]")
    private WebElement mensajeCorrectamenteElement;

    public boolean esperarMensajeRutNoIngresado() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Esperar a que aparezca el mensaje "Datos insertados correctamente"
        By mensajeSelector = By.xpath("//div[contains(text(),'Ingrese un rut válido')]");

        try {
            // Esperar a que el elemento esté presente en el DOM y sea visible
            WebElement mensajeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(mensajeSelector));

            // Si el mensaje está presente y es visible, retornar true
            return mensajeElement.isDisplayed();
        } catch (Exception e) {
            // Si ocurre una excepción (timeout), retornar false
            return false;
        }
    }
    public void aceptarAlertRutNoValido() {
        btnOkAlert.click();
    }

    public void okAlumnoAgregado(){
        //ok pop-up
        btnOkAlert.click();
        //click alumno nuevo
        btnAgregarAlumnoNuevo.click();
    }

    public void okAlumnoNoAgregado(String run) {
        btnOkAlert.click();
        //click en "Volver lista de alumnos
        btnListaAlumnos.click();
        //click en agregar nuevo alumno
        btnAgregarAlumno2.click();
    }
    public boolean okAlumnoNoAgregado2(String run,int posicion) {
        //click en "Volver lista de alumnos
        btnListaAlumnos.click();

        //metodo buscar()
        boolean verificado = buscarRut(run,posicion);
        //click en agregar nuevo alumno
        btnAgregarAlumno2.click();
        return verificado;

    }

    public boolean buscarRut(String rut,int posicion){
        inBuscarRun.sendKeys(rut);
        boolean exito=false;
        try{
            if(tabla.isDisplayed()){
                exito = true;
            }
        } catch (NoSuchElementException e){

        }
        return exito;
    }
    public boolean esperarMensajeDatosInsertados2() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(8));

        // Esperar a que aparezca el mensaje "Datos insertados correctamente"    //div[contains(text(),'Datos insertados correctamente')]
        By mensajeSelector = By.xpath("//div[@role='dialog']");

        try {
            // Esperar a que el elemento esté presente en el DOM
            wait.until(ExpectedConditions.presenceOfElementLocated(mensajeSelector));

            if(mensajeElement.isDisplayed()){
                return true;
            } else {
                return false;
            }

        } catch (TimeoutException e) {
            // Si ocurre una excepción (timeout), retornar false
            return false;
        }
    }

//-----------------------------------------------------------------------------------------

    public boolean esperarMensajeDatosInsertados() {
        boolean exito = false;

        try {
            // Esperar a que el elemento esté presente en el DOM
            wait.until(ExpectedConditions.visibilityOf(mensajeElement));

            try {
                // Verificar si el mensaje está siendo visualizado
                if (mensajeElement.isDisplayed()) {
                    // Esperar a que el mensaje de éxito esté presente en el DOM
                    wait.until(ExpectedConditions.visibilityOf(mensajeCorrectamenteElement));

                    // Verificar si el mensaje correcto está siendo visualizado
                    if (mensajeCorrectamenteElement.isDisplayed()) {
                        exito = true;
                    }
                }
            } catch (NoSuchElementException e) {
                System.out.println("Mensaje no encontrado");
            }
        } catch (TimeoutException e) {
            // Si ocurre una excepción (timeout), retornar false
            System.out.println("Timeout esperando el elemento");
        }

        return exito;
    }
    public void inRun(String rutt) {
        rut.sendKeys(rutt);
    }
    public void ingresardatos(String nom, String ape, int eda, String pasa,
                              String se, String eje, String numero, String eemail, String en,
                              String dire, String ciu, String com, String nApo, String numerAp,String emmail,
                              String cTipo, int ini, int dura, String lis) {
        Utilities.esperar(2);
        name.sendKeys(nom);
        Utilities.esperar(1);
        apellido.sendKeys(ape);
        String edaad = String.valueOf(eda);
        edad.sendKeys(edaad);
        pasaporte.sendKeys(pasa);
        Select selecciona = new Select(sex);
        selecciona.selectByVisibleText(se);
        Select elegi = new Select(ejecutivo);
        elegi.selectByVisibleText(eje);
        num.sendKeys(numero);
        email.sendKeys(eemail);
        entrevista.sendKeys(en);
        direccion.sendKeys(dire);
        ciudad.sendKeys(ciu);
        comuna.sendKeys(com);
        nomApoderado.sendKeys(nApo);
        numApoderado.sendKeys(numerAp);
        emailApoderado.sendKeys(emmail);
        Select tipo = new Select(cursoTipo);
        tipo.selectByVisibleText(cTipo);
        String inicio = String.valueOf(ini);
        cursoInicio.sendKeys(inicio);
        String duracion = String.valueOf(dura);
        cursoDuracion.sendKeys(duracion);
        Select lista = new Select(curso);
        lista.selectByVisibleText(lis);

        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(btnAgregarAlumno));
        element.click();

    }


    //inicio sesion
    public void agregarAlumno1(){
        btnAlumno.click();
        Utilities.esperar(1);
        btnAgregarAlumno.click();
    }
    public void inicioSesion(String eemail, String pass){
        inusuario.sendKeys(eemail);
        incontrasena.sendKeys(pass);
        btnEntrar.click();
        Utilities.esperar(2);
    }


}

