//package BackTest;
//
//import io.restassured.RestAssured;
//import io.restassured.path.json.JsonPath;
//import io.restassured.response.Response;
//import org.junit.jupiter.api.Test;
//import org.testng.Assert;
//
//public class GetTest {
//    @Test
//    public void GetTest_01 () {
//        Response resGet = RestAssured.get("https://reqres.in/api/users?page=2");
//        System.out.println("El código obtenido es: " + resGet.statusCode());
//        System.out.println("Se tardo: " + resGet.getTime() + " milisegundos");
//        System.out.println(resGet.getBody().asString());
//    }
//
//    @Test
//    public void GetTest_02 () {
//        Response resGet = RestAssured.get("https://reqres.in/api/users?page=2");
//        System.out.println("El código obtenido es: " + resGet.statusCode());
//        System.out.println("Se tardo: " + resGet.getTime() + " milisegundos");
//
//        Assert.assertEquals(resGet.statusCode(), 200);
//        Assert.assertEquals(resGet.body().jsonPath().getString("data.email[0]"), "michael.lawson@reqres.in");
//    }
//
//    @Test
//    public void GetTest_03 () {
//        Response resGet = RestAssured.get("https://reqres.in/api/users?page=2");
//
//        JsonPath ResponseBody =resGet.jsonPath();
//        String nombre_0 = ResponseBody.getString("data.first_name[0]");
//        String apellido_0 = ResponseBody.getString("data.last_name[0]");
//        String nombre_1 = ResponseBody.getString("data.first_name[1]");
//        String apellido_1 = ResponseBody.getString("data.last_name[1]");
//        String nombre_2 = ResponseBody.getString("data.first_name[2]");
//        String apellido_2 = ResponseBody.getString("data.last_name[2]");
//        String nombre_3 = ResponseBody.getString("data.first_name[3]");
//        String apellido_3 = ResponseBody.getString("data.last_name[3]");
//        int statusCode = resGet.statusCode();
//
//        Assert.assertEquals(nombre_0, "Michael");
//        Assert.assertEquals(apellido_0, "Lawson");
//        Assert.assertEquals(nombre_1, "Lindsay");
//        Assert.assertEquals(apellido_1, "Ferguson");
//        Assert.assertEquals(nombre_2, "Tobias");
//        Assert.assertEquals(apellido_2, "Funke");
//        Assert.assertEquals(nombre_3, "Byron");
//        Assert.assertEquals(apellido_3, "Fields");
//        Assert.assertEquals(statusCode, 200);
//
//        System.out.println("El código obtenido es: " + resGet.statusCode());
//        System.out.println("Se tardo: " + resGet.getTime() + " milisegundos");
//    }
//}