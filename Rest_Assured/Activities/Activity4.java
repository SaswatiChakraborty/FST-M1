package activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity4 {
    RequestSpecification requestSpec;
    ResponseSpecification responseSpec;
    String BASE_URI = "https://petstore.swagger.io/v2/pet";
    String ROOT_URI = "https://petstore.swagger.io/v2/pet/{petId}";

    @BeforeClass
    public void setUp() {
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("BASE_URI")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType("application/json")
                .expectBody("status", equalTo("alive"))
                .build();
    }

    @Test(priority = 0)
    void validatePostRequestforPet1(){
        String pet1  = "{"
                + "\"id\": 77232,"
                + "\"name\": \"Riley\","
                + " \"status\": \"alive\""
                + "}";

        Response response = given().contentType(ContentType.JSON).body(pet1).when().post(BASE_URI);

        System.out.println(response.asPrettyString());
        response.then().body("id", equalTo(77232));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
    }

    @Test(priority = 0)
    void validatePostRequestforPet2(){
        String pet2  = "{"
                + "\"id\": 77233,"
                + "\"name\": \"Hansel\","
                + " \"status\": \"alive\""
                + "}";

        Response response = given().contentType(ContentType.JSON).body(pet2).when().post(BASE_URI);

        System.out.println(response.asPrettyString());
        response.then().body("id", equalTo(77233));
        response.then().body("name", equalTo("Hansel"));
        response.then().body("status", equalTo("alive"));
    }

    @DataProvider
    public Object[][] dataProvider() {
        Object[][] testData = new Object[][] {
                { 77232, "Riley", "alive" },
                { 77233, "Hansel", "alive" }
        };
        return testData;
    }

    @Test(priority=1, dataProvider = "dataProvider")
    void ValidateGetRequest(int id, String name, String status){
        Response response =
                given().contentType(ContentType.JSON).when().pathParam("petId", id).when().get(ROOT_URI);

        System.out.println(response.asPrettyString());
        response.then().spec(responseSpec);
    }

    @Test(priority = 2, dataProvider = "dataProvider")
    void ValidateDeleteRequest(int id, String name, String status){
        Response response =
                given().contentType(ContentType.JSON).when().pathParam("petId", id).when().delete(ROOT_URI);
        System.out.println(response.asPrettyString());
        response.then().body("code", equalTo(200));
    }
}
