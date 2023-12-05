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
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.setUp();
        loginPage.getUrl("http://testing.ctd.academy/");
    }

    @Test
    @Tag("Login")
    @Tag("ALL")
    public void LoginExitosoTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Login Exitoso");
        test.log(Status.INFO, "Comienza el Test");
        LoginPage loginPage = new LoginPage(driver, wait);


    }

    @Test
    @Tag("Login")
    @Tag("ALL")
    public void LoginFallidoTest() throws InterruptedException {

    }

    @AfterEach
    public void cerrar() {
        LoginPage loginPage = new LoginPage(driver, wait);
        loginPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }
}
