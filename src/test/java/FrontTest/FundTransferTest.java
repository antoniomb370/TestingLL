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

public class FundTransferTest {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/openNewAccountTest.html");
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
        FundTransfer fundTransfer = new FundTransfer(driver, wait);
        fundTransfer.setUp();
        fundTransfer.getUrl("https://parabank.parasoft.com/parabank/admin.htm");
    }
    @Test
    @Tag("Login")
    @Tag("ALL")
    public void FundTransfer() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Transferencia de Fondos");
        test.log(Status.INFO, "Comienza el Test");
        FundTransfer fundTransfer = new FundTransfer(driver, wait);
        try {
            loginPage.login("1", "1");
            fundTransfer.clickFundTransfer();
            test.log(Status.INFO, "Click en Transferencia de Fondos");
            Thread.sleep(3000);
            fundTransfer.enterAmount("100");
            fundTransfer.selectFromAccount("15120");
            fundTransfer.selectToAccount("15231");
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            fundTransfer.clickTransfer();
            test.log(Status.INFO, "Click en Transferir");
            Thread.sleep(3000);
            String messageFundTransfer = fundTransfer.obtenerMensajeFundTransfer();
            assertEquals("Transfer Complete!", messageFundTransfer);
            test.pass("Se realizó la transferencia de fondos");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }
    @AfterEach
    public void cerrar() {
        FundTransfer fundTransfer = new FundTransfer(driver, wait);
        fundTransfer.close();
    }
    @AfterAll
    public static void reporte() {
        extent.flush();
    }


}
