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

public class CreateAccountTest {

    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/GetCreateAccount.html");
    static ExtentReports extent;


    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @Test
    @Tag("AccountCreation")
    @Tag("TESTBACK")
    public void CreateAccountTest() {
        ExtentTest test = extent.createTest("Prueba de creación de cuenta - Metodo POST");
        try {
            test.log(Status.INFO, "Comienza el Test");
            int customerId = 26975;
            int newAccountType = 1; // Supongamos que 1 representa CHECKING
            int fromAccountId = 44424;

            Response resPost = RestAssured.given()
                    .queryParam("customerId", customerId)
                    .queryParam("newAccountType", newAccountType)
                    .queryParam("fromAccountId", fromAccountId)
                    .when()
                    .post("https://parabank.parasoft.com/parabank/services/bank/createAccount");

            System.out.println("El código obtenido es: " + resPost.statusCode());
            System.out.println("Se tardo: " + resPost.getTime() + " milisegundos");

            XmlPath xmlPath = resPost.xmlPath();
            int id = xmlPath.getInt("account.id");
            int customerIdResponse = xmlPath.getInt("account.customerId");
            String type = xmlPath.getString("account.type");
            int balance = xmlPath.getInt("account.balance");

            System.out.println("ID: " + id);
            System.out.println("Customer ID: " + customerIdResponse);
            System.out.println("Type: " + type);
            System.out.println("Balance: " + balance);

            Assert.assertEquals(resPost.statusCode(), 200);
            test.log(Status.PASS, "Se realizo la creación de cuenta de forma exitosa");
        } catch (Exception e) {
            test.log(Status.FAIL, "La prueba falló: " + e.getMessage());
        }
    }
    @AfterAll
    public static void reporte() {
        extent.flush();
    }
}