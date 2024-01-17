package Page;

import drivers.DriverContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {

    private WebDriver driver;

    public static void chromeDriverConnection() {
        System.setProperty("webdriver.chrome.driver", "src/Driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        DriverContext.setDriver(driver);
    }

    public static void visitUrl(String url){
        DriverContext.getDriver().get(url);
        DriverContext.getDriver().manage().window().maximize();
    }
    public WebElement devolverWebelement(By localizador){
        return this.driver.findElement(localizador);
    }
}

