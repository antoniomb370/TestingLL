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

public class AccountsOverviewTest {

    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/AccountsOverviewTest.html");
    static ExtentReports extent;
    LoginPage loginPage = new LoginPage(driver, wait);
    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        AccountsOverview accountsOverview = new AccountsOverview(driver, wait);
        accountsOverview.setUp();
        accountsOverview.getUrl("https://parabank.parasoft.com/parabank/index.htm");

    }

    @Test
    @Tag("Login")
    @Tag("ALL")
    public void AccountsOverview() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Resumen de Cuentas");
        test.log(Status.INFO, "Comienza el Test");
        AccountsOverview accountsOverview = new AccountsOverview(driver, wait);
        try {
            loginPage.login("1", "1");
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            accountsOverview.clickAccountsOverview();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            test.log(Status.INFO, "Click en resumen de cuentas");
            String messageAccountsOverview = accountsOverview.obtenerMensajeAccountsOverview();
            assertEquals("*Balance includes deposits that may be subject to holds", messageAccountsOverview);
            test.pass("Seleccionado tipo de cuenta SAVINGS");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }


    @AfterEach
    public void cerrar() throws InterruptedException {


        OpenNewAccount openNewAccount = new OpenNewAccount(driver, wait);
        openNewAccount.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }

}
