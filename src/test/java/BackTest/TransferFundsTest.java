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

public class TransferFundsTest {

    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/PosTransferFunds.html");
    static ExtentReports extent;


    @BeforeAll
    public static void crearReporte() {
        extent = ExtentFactory.getInstance();
        extent.attachReporter(info);
    }

    @Test
    @Tag("TransferFunds")
    @Tag("TESTBACK")
    public void TransferFundsTest_01() {
        ExtentTest test = extent.createTest("Prueba de transferencia de fondos - Metodo POST");
        try {
            test.log(Status.INFO, "Comienza el Test");
            int fromAccountId = 47532;
            int toAccountId = 46422;
            double amount = 100.0;

            Response resPost = RestAssured.given()
                    .queryParam("fromAccountId", fromAccountId)
                    .queryParam("toAccountId", toAccountId)
                    .queryParam("amount", amount)
                    .when()
                    .post("https://parabank.parasoft.com/parabank/services/bank/transfer");

            System.out.println("El código obtenido es: " + resPost.statusCode());
            System.out.println("Se tardo: " + resPost.getTime() + " milisegundos");
            System.out.println(resPost.getBody().asString());

            Assert.assertEquals(resPost.statusCode(), 200);
            Assert.assertEquals(resPost.getBody().asString(), "Successfully transferred $" + amount + " from account #" + fromAccountId + " to account #" + toAccountId);
            test.log(Status.PASS, "Se realizo la transferencia de fondos de forma exitosa");
        } catch (Exception e) {
            test.log(Status.FAIL, "La prueba falló: " + e.getMessage());
        }
    }

    @AfterAll
    public static void reporte() {
        extent.flush();
    }

}