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


public class OpenNewAccountTest {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/OpenNewAccountTest.html");
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
        OpenNewAccount openNewAccount = new OpenNewAccount(driver, wait);
        openNewAccount.setUp();
        openNewAccount.getUrl("https://parabank.parasoft.com/parabank/index.htm");

    }
    @Test
    @Tag("Login")
    @Tag("ALL")
    public void testOpenNewAccount() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba abrir nueva cuenta");
        test.log(Status.INFO, "Comienza el Test");
        OpenNewAccount openNewAccount = new OpenNewAccount(driver, wait);
        try {
            loginPage.login("1", "1");
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            openNewAccount.clickOpenNewAccount();
            test.log(Status.INFO, "Click en abrir nueva cuenta");
            openNewAccount.selectAccountType("SAVINGS");
            Thread.sleep(2000);
            openNewAccount.clickOpenNewAccountButton();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String messageNewAccount = openNewAccount.obtenerMensajeNewAccount();
            assertEquals("Congratulations, your account is now open.", messageNewAccount);
            test.pass("Seleccionado tipo de cuenta SAVINGS");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }

    @AfterEach
    public void cerrar() {
        OpenNewAccount openNewAccount = new OpenNewAccount(driver, wait);
        openNewAccount.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }
}
