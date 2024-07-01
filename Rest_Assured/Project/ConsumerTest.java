package liveProject;


import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {
    //set the header
    Map<String,String> headers = new HashMap<>();

    //create the contact pact
    @Pact(consumer = "userConsumer" , provider = "userProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder){

        //add headers
        headers.put("Content-Type","application/json");

        //write resquest and response bode
        DslPart requestResponeBody = new PactDslJsonBody()
                .numberType("id", 123)
                .stringType("firstName", "Saswati")
                .stringType("lastName","Chakraborty")
                .stringType("email","saswati@test.com");

        //write the interactions
       return builder.given("Post Request")
               .uponReceiving("a post request sends to provider")
               .method("POST")
               .path("/api/users")
               .headers(headers)
               .body(requestResponeBody)
               .willRespondWith()
               .status(201)
               .body(requestResponeBody)
               .toPact();
    }

    //junit test function
    @Test
    @PactTestFor(providerName = "userProvider", port = "8282")
    public void postRequest(){
        Map<String,Object> reqBody = new HashMap<>();
        reqBody.put("id",123);
        reqBody.put("firstName", "Saswati");
        reqBody.put("lastName","Chakraborty");
        reqBody.put("email","saswati@test.com");

        // send request get response and assert response
        given().baseUri("http://localhost:8282").headers(headers)
                .body(reqBody).when()
                .post("/api/users").then()
                .statusCode(201).body("email", equalTo("saswati@test.com")).log().all();

        given().baseUri("http://localhost:8282").headers(headers).body(reqBody)
                .when().post("/api/users").then().statusCode(201).log().all();
    }
}
