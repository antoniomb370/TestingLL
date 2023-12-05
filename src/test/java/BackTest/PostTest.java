//package BackTest;
//
//import com.google.gson.JsonObject;
//import org.junit.jupiter.api.Test;
//import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;
//
//public class PostTest {
//    @Test
//    public void PostTest_01() {
//        JsonObject request = new JsonObject();
//        request.addProperty("name", "SERGIO");
//        request.addProperty("job", "PROFESOR");
//
//        given()
//                .contentType("application/json")
//                .body(request)
//                .when().post("https://reqres.in/api/users")
//                .then().statusCode(201)
//                .log().status()
//                .log().body();
//    }
//
//    @Test
//    public void PostTest_02() {
//        JsonObject request = new JsonObject();
//        request.addProperty("name", "SERGIO");
//        request.addProperty("job", "PROFESOR");
//        given()
//                .contentType("application/json")
//                .body(request)
//                .when().post("https://reqres.in/api/users")
//                .then().statusCode(201)
//                .body("name", equalTo("SERGIO"))
//                .body("job", equalTo("PROFESOR"))
//                .body("createdAt", containsString("2023-11-15"))
//                .log().status()
//                .log().body();
//    }
//}