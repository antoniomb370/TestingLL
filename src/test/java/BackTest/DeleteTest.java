//package BackTest;
//
//import com.google.gson.JsonObject;
//import org.junit.jupiter.api.Test;
//
//import static io.restassured.RestAssured.given;
//
//public class DeleteTest {
//    @Test
//    public void DeleteTest_01() {
//        String usuario = "288";
//
//        given()
//                .when().delete("https://reqres.in/api/users/" + usuario)
//                .then().statusCode(204)
//                .log().status();
//    }
//}
