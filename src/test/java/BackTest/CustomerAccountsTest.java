package BackTest;

import Reportes.ExtentFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.testng.Assert;

public class CustomerAccountsTest {
    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/GetCustomerAccounts.html");
    static ExtentReports extent;

    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @Test
    @Tag("CustomerAccounts")
    @Tag("TESTBACK")
    public void CustomerAccountsTest() {
        ExtentTest test = extent.createTest("Prueba de obtención de cuentas de cliente - Metodo GET");
        try {
            test.log(Status.INFO, "Comienza el Test");
            int customerId = 26975;
            Response resGet = RestAssured.get("https://parabank.parasoft.com/parabank/services/bank/customers/" + customerId + "/accounts");
            System.out.println("El código obtenido es: " + resGet.statusCode());
            System.out.println("Se tardo: " + resGet.getTime() + " milisegundos");
            System.out.println(resGet.getBody().asString());
            Assert.assertEquals(resGet.statusCode(), 200);
            test.log(Status.PASS, "Se realizo la obtención de cuentas de cliente de forma exitosa");
        } catch (Exception e) {
            test.log(Status.FAIL, "La prueba falló: " + e.getMessage());
        }
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }
}