package Step;

import Page.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {
    @Before
    public void beforeScenario(Scenario scenario){
        System.out.println("before hook");
        BasePage.chromeDriverConnection(); //levanta el navegador chrome y configura chrome
    }

    @After
    public void afterScenario(Scenario scenario){
        System.out.println("after hook");
        //Base.cerrarNav();
    }
}

