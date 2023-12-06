import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterTest {
    private WebDriver driver;
    private WebDriverWait wait;
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/RegisterTest.html");
    static ExtentReports extent;
    int randomNum = new Random().nextInt(10000);

    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.setUp();
        registerPage.getUrl("https://parabank.parasoft.com/parabank/admin.htm");
    }

    @Test
    @Tag("Registro")
    @Tag("ALL")
    public void RegistroExitosoTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Crear Cuenta Exitosa");
        test.log(Status.INFO, "Comienza el Test");
        RegisterPage registerPage = new RegisterPage(driver, wait);

        try {
            registerPage.clickRegistrarse();
            registerPage.fillRegistrationForm("John", "Doe", "123 Main St", "Anytown", "Anystate", "12345", "123-456-7890", "123-45-6789", "johntesting2" + randomNum, "password", "password");
            registerPage.clickRegister();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String successMessage = registerPage.getSuccessMessage();
            String welcomeMessage = registerPage.getWelcomeMessage();
            assertEquals("Your account was created successfully. You are now logged in.", successMessage);
            assertTrue(welcomeMessage.startsWith("Welcome"));
            test.log(Status.PASS, "Regreso a la página inicial");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }

    @Test
    @Tag("Registro")
    @Tag("ALL")
    public void RegistroUsuarioExistenteTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Crear Cuenta con Usuario Existente");
        test.log(Status.INFO, "Comienza el Test");
        RegisterPage registerPage = new RegisterPage(driver, wait);

        try {
            String username = "pepitobanana1";
            registerPage.clickRegistrarse();
            registerPage.fillRegistrationForm("John", "Doe", "123 Main St", "Anytown", "Anystate", "12345", "123-456-7890", "123-45-6789", username, "banana1", "banana1");
            registerPage.clickRegister();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            String errorMessage = registerPage.getErrorMessage();
            assertEquals("This username already exists.", errorMessage);
            test.log(Status.PASS, "Se muestra el mensaje de error esperado");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }

    @Test
    @Tag("Registro")
    @Tag("ALL")
    public void RegistroCamposVaciosTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Crear Cuenta con Campos Vacíos");
        test.log(Status.INFO, "Comienza el Test");
        RegisterPage registerPage = new RegisterPage(driver, wait);
        DataValidator dataValidator = new DataValidator(driver, wait);
        try {
            registerPage.clickRegistrarse();
            registerPage.fillRegistrationForm("", "", "", "", "", "", "", "", "", "", "");
            registerPage.clickRegister();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            assertEquals("First name is required.", dataValidator.getFirstNameError());
            assertEquals("Last name is required.", dataValidator.getLastNameError());
            assertEquals("Address is required.", dataValidator.getAddressError());
            assertEquals("City is required.", dataValidator.getCityError());
            assertEquals("State is required.", dataValidator.getStateError());
            assertEquals("Zip Code is required.", dataValidator.getZipCodeError());
            assertEquals("Social Security Number is required.", dataValidator.getSsnError());
            assertEquals("Username is required.", dataValidator.getUsernameError());
            assertEquals("Password is required.", dataValidator.getPasswordError());
            assertEquals("Password confirmation is required.", dataValidator.getConfirmPasswordError());
            test.log(Status.PASS, "Se muestran los mensajes de error esperados");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }

    @Test
    @Tag("Registro")
    @Tag("ALL")
    public void RegistroContrasenasNoCoincidenTest() throws InterruptedException {
        ExtentTest test = extent.createTest("Prueba de Crear Cuenta con Contraseñas que no Coinciden");
        test.log(Status.INFO, "Comienza el Test");
        RegisterPage registerPage = new RegisterPage(driver, wait);
DataValidator dataValidator = new DataValidator(driver, wait);
        try {
            registerPage.clickRegistrarse();
            registerPage.fillRegistrationForm("John", "Doe", "123 Main St", "Anytown", "Anystate", "12345",
                    "123-456-7890", "123-45-6789", "johndoe", "password", "password2");
            registerPage.clickRegister();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            assertEquals("Passwords did not match.", dataValidator.getMensajePasswordNotMatch());
            test.log(Status.PASS, "Se muestra el mensaje de error esperado");
        } catch (AssertionError error) {
            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
            throw error;
        }
    }

    @AfterEach
    public void cerrar() throws InterruptedException {
        RegisterPage registerPage = new RegisterPage(driver, wait);
        registerPage.close();
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }
}
