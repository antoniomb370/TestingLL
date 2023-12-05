import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/LoginTest.html");
    static ExtentReports extent;

    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.setUp();
        loginPage.getUrl("https://parabank.parasoft.com/parabank/admin.htm");
    }

    @Test
    @Tag("Login")
    @Tag("ALL")
    public void LoginExitosoTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Login Exitoso");
        test.log(Status.INFO, "Comienza el Test");
        LoginPage loginPage = new LoginPage(driver, wait);

        try {

            loginPage.fillLoginForm("johntesting2", "password");
            loginPage.clickLogin();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String messageAccountsTitulo = loginPage.obtenerMensajeVienvenida();
            String messageAccountsFooter = loginPage.obtenerMensajeAccounts();
            assertEquals("Accounts Overview", messageAccountsTitulo);
            assertEquals("*Balance includes deposits that may be subject to holds", messageAccountsFooter);
            test.log(Status.PASS, "Regreso a la página inicial");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }



    @AfterEach
    public void cerrar() throws InterruptedException {
  // quiero que dure 10 segundos antes de cerrar
        Thread.sleep(10000);
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }
}
