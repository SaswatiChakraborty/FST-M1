package activities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity1 {
    String POST_URI = "https://petstore.swagger.io/v2/pet";
    String ROOT_URI = "https://petstore.swagger.io/v2/pet/{petId}";

    @Test(priority = 0)
    void validatePostRequest(){
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("id", 77232);
        reqBody.put("name", "Riley");
        reqBody.put("status", "alive");

        Response response = given().contentType(ContentType.JSON).body(reqBody).when().post(POST_URI);

        System.out.println(response.asPrettyString());
        response.then().body("id", equalTo(77232));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
    }

    @Test(priority = 1)
    void ValidateGetRequest(){
         Response response =
                given().contentType(ContentType.JSON).when().pathParam("petId", "77232").when().get(ROOT_URI);

        System.out.println(response.asPrettyString());
        response.then().body("id", equalTo(77232));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
    }

    @Test(priority = 2)
    void ValidateDeleteRequest(){
        Response response =
                given().contentType(ContentType.JSON).when().pathParam("petId", "77232").when().delete(ROOT_URI);
        System.out.println(response.asPrettyString());
        response.then().body("code", equalTo(200));
    }
}
