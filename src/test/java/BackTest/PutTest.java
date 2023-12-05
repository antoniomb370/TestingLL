//package BackTest;
//
//import Reportes.ExtentFactory;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.google.gson.JsonObject;
//import io.restassured.response.Response;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Tag;
//import org.junit.jupiter.api.Test;
//import org.testng.Assert;
//
//import static io.restassured.RestAssured.given;
//
//public class PutTest {
//    static ExtentSparkReporter info = new ExtentSparkReporter("target/REPORTES/PutTest.html");
//    static ExtentReports extent;
//
//    @BeforeAll
//    public static void crearReporte() {
//        extent = ExtentFactory.getInstance();
//        extent.attachReporter(info);
//    }
//
//    @Test
//    @Tag("PUT")
//    @Tag("TEST_BACK")
//    public void PutTest_01() {
//        ExtentTest test = extent.createTest("Prueba de modificación Exitosa - Metodo PUT");
//        test.log(Status.INFO, "Comienza el Test");
//        JsonObject request = new JsonObject();
//        request.addProperty("name", "PACE");
//        request.addProperty("job", "ESTUDIANTE");
//        test.log(Status.PASS, "Creamos nuestro request");
//
//        try {
//            given()
//                    .contentType("application/json")
//                    .body(request)
//                    .when().put("https://reqres.in/api/users/287")
//                    .then().statusCode(200)
//                    .log().status()
//                    .log().body();
//            test.log(Status.PASS, "Se realizo la validación de forma exitosa");
//        } catch (AssertionError error){
//            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
//            throw error;
//        }
//    }
//
//    @Test
//    @Tag("PUT")
//    @Tag("TEST_BACK")
//    public void PutTest_02() {
//        ExtentTest test = extent.createTest("Segunda Prueba de modificación Exitosa - Metodo PUT");
//        test.log(Status.INFO, "Comienza el Test");
//        JsonObject request = new JsonObject();
//        request.addProperty("name", "PACE");
//        request.addProperty("job", "ESTUDIANTE");
//        test.log(Status.PASS, "Creamos nuestro request");
//
//        try {
//            Response responseBody = given()
//                    .contentType("application/json")
//                    .body(request)
//                    .when().put("https://reqres.in/api/users/287");
//            test.log(Status.PASS, "Realizamos el metodo PUT");
//
//            String nombreModificado = responseBody.jsonPath().getString("name");
//            String trabajoModificado = responseBody.jsonPath().getString("job");
//
//            Assert.assertEquals(nombreModificado, "PACE");
//            Assert.assertEquals(trabajoModificado, "ESTUDIANTE");
//            Assert.assertEquals(responseBody.statusCode(), 200);
//            test.log(Status.PASS, "Se realizo la validación de forma exitosa");
//        } catch (AssertionError error){
//            test.log(Status.FAIL, "Fallo la validación: " + error.getLocalizedMessage());
//            throw error;
//        }
//    }
//
//    @AfterAll
//    public static void reporte() {
//        extent.flush();
//    }
//}
