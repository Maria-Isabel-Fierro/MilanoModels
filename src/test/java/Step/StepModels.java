package Step;

import Page.BasePage;
import Page.MilanoPage;
import Page.SistemPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepModels {

    MilanoPage milanoPage = new MilanoPage();
    SistemPage sistemPage = new SistemPage();

    @Given("El usuario esta en la pagina de Milano {string}")
    public void elUsuarioEstaEnLaPaginaDeMilano(String arg0) {

        BasePage.visitUrl(arg0);
    }

    @Then("ingresa usuario {string} y password {string}")
    public void ingresaUsuarioYPassword(String arg0, String arg1) {

        milanoPage.inicioSesion(arg0,arg1);
    }

    @And("El usuario accede a la seccion de agregar nuevo alumno")
    public void elUsuarioAccedeALaSeccionDeAgregarNuevoAlumno() {

        milanoPage.agregarAlumno1();
    }

    @When("El usuario ingresa informacion para un nuevo alumno")
    public void elUsuarioIngresaInformacionParaUnNuevoAlumno() {

        sistemPage.test();
    }
}
