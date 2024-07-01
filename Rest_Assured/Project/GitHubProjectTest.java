package liveProject;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class GitHubProjectTest {
    String SSHKey = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAILqTM9LFHkyBOiopUPRQfdz4uW9Uq3QLinDzcWqhMSdv";
    int sshKeyId;

    RequestSpecification requestSpec = new RequestSpecBuilder().
            setBaseUri("https://api.github.com/user/keys")
            .addHeader("Authorization", "token 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")
            .addHeader("Content-Type","application/json")
            .build();

    ResponseSpecification responseSec = new ResponseSpecBuilder()
            .expectResponseTime(lessThan(1700L))
            .expectBody("key", equalTo(SSHKey))
            .expectBody("title",equalTo("TestAPIKey"))
            .build();

    @Test(priority = 1)
    public void postRequestTest(){
        Map<String, Object> reqBody = new HashMap<>();
        reqBody.put("title","TestAPIKey");
        reqBody.put("key", SSHKey);

        Response respose = given().spec(requestSpec).body(reqBody).when().post();

        sshKeyId = respose.then().extract().path("id");

        respose.then().statusCode(201).spec(responseSec);
    }

    @Test(priority = 2)
    public void getRequestTest(){
        given().spec(requestSpec).pathParam("keyId", sshKeyId)
                .when().get("/{keyId}").then().
                statusCode(200).spec(responseSec);
    }

    @Test(priority = 3)
    public void deleteRequestTest(){
        given().spec(requestSpec).pathParam("keyId", sshKeyId)
                .when().delete("/{keyId}").then().
                statusCode(204).time(lessThan(3000L));
    }
}
