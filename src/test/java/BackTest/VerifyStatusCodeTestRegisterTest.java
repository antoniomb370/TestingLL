package BackTest;


import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.testng.Assert;
public class VerifyStatusCodeTestRegisterTest {

    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/GetVerifyStatusCodeTestRegister.html");
    static ExtentReports extent;


    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @Test
    @Tag("StatusCodeVerification")
    @Tag("TESTBACK")
    public void VerifyStatusCodeTest() {
        ExtentTest test = extent.createTest("prueba de verificación de código de estado - Metodo GET, se ingresa a la página de registro");
        try {
            test.log(Status.INFO, "Comienza el Test");
            Response resGet = RestAssured.get("https://parabank.parasoft.com/parabank/register.htm");
            System.out.println("El código obtenido es: " + resGet.statusCode());
            System.out.println("Se tardo: " + resGet.getTime() + " milisegundos");
            Assert.assertEquals(resGet.statusCode(), 200, "El código de estado no es 200");
            test.log(Status.PASS, "Se realizo la verificación de código de estado de forma exitosa, se ingresa a la página de registro");
        } catch (Exception e) {
            test.log(Status.FAIL, "La prueba falló: " + e.getMessage());
        }
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }
}
