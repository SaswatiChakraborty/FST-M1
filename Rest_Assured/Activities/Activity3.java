package activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity3 {
    String POST_URI = "https://petstore.swagger.io/v2/user";
    String ROOT_URI = "https://petstore.swagger.io/v2/user/{username}";

    @Test(priority = 0)
    void validatePostRequest() throws IOException {
        FileInputStream inputJSON = new FileInputStream("src/test/testData/userinfo.json");
        String requestBody = new String(inputJSON.readAllBytes());

        Response response = given().contentType(ContentType.JSON).body(requestBody).when().post(POST_URI);

        System.out.println(response.asPrettyString());
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("147895"));
    }

    @Test(priority = 1)
    void ValidateGetRequest(){
         Response response =
                given().contentType(ContentType.JSON).when().pathParam("username", "tinJus").when().get(ROOT_URI);

        System.out.println(response.asPrettyString());
        response.then().body("id", equalTo(147895));
        response.then().body("username", equalTo("tinJus"));
        response.then().body("firstName", equalTo("Justin"));
        response.then().body("lastName", equalTo("Case"));
        response.then().body("email", equalTo("justincase@mail.com"));
        response.then().body("password", equalTo("password123"));
        response.then().body("phone", equalTo("9812763450"));
        response.then().body("userStatus", equalTo(0));
    }

    @Test(priority = 2)
    void ValidateDeleteRequest(){
        Response response =
                given().contentType(ContentType.JSON).when().pathParam("username", "tinJus").when().delete(ROOT_URI);
        System.out.println(response.asPrettyString());
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("tinJus"));

    }
}
