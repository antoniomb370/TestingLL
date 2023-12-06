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

public class LoginTest {

        static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/GetLogin.html");
        static ExtentReports extent;


        @BeforeAll
        public static void crearReporte() {
            extent = ExtentFactory.getInstance();
            extent.attachReporter(info);
        }

    @Test
    @Tag("Login")
    @Tag("TESTBACK")
    public void LoginTest_01() {
        ExtentTest test = extent.createTest("Prueba de Login Exitoso - Metodo GET");
        try {
            test.log(Status.INFO, "Comienza el Test");
            String username = "1";
            String password = "1";
            Response resGet = RestAssured.get("https://parabank.parasoft.com/parabank/services/bank/login/" + username + "/" + password);
            System.out.println("El código obtenido es: " + resGet.statusCode());
            System.out.println("Se tardo: " + resGet.getTime() + " milisegundos");
            System.out.println(resGet.getBody().asString());
            Assert.assertEquals(resGet.statusCode(), 200);
            test.log(Status.PASS, "Se realizo el login de forma exitosa");
        } catch (Exception e) {
            test.log(Status.FAIL, "La prueba falló: " + e.getMessage());
        }
    }

        @AfterAll
    public static void reporte() {
        extent.flush();
    }
    }
