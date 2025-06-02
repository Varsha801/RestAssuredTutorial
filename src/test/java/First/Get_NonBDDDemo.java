package First;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.Test;
 
public class Get_NonBDDDemo {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
 
    @Test
    public void verifyStatusCode() {
 
        RestAssured.baseURI = "http://dummy.restapiexample.com/api/v1/employees";
 
        // Create a request specification
        requestSpecification = RestAssured.given();
 
        // Calling GET method
        response = requestSpecification.get();
 
        // Let's print response body.
        String resString = response.prettyPrint();
        System.out.println("Response Details : " + resString);
 
        /*
         * To perform validation on response, we need to get ValidatableResponse type of
         * response
         */
        validatableResponse = response.then();
 
        // Get status code
        validatableResponse.statusCode(200);
 
        // Check status line is as expected
        validatableResponse.statusLine("HTTP/1.1 200 OK");
 
    }
    
    @Test
    public void verifyStatusCode1() {
 
        String jsonString = "{\"name\":\"newapitest\",\"salary\":\"4000\",\"age\":\"29\"}";
 
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/create";
 
        // Create a request specification
        requestSpecification = RestAssured.given();
 
        // Setting content type to specify format in which request payload will be sent.
        requestSpecification.contentType(ContentType.JSON);
 
        // Adding body as string
        requestSpecification.body(jsonString);
 
        // Calling POST method
        response = requestSpecification.post();
 
        // Let's print response body.
        String responseString = response.prettyPrint();
 
        /*
         * To perform validation on response, we need to get ValidatableResponse type of
         * response
         */
        validatableResponse = response.then();
 
        // Check status code
        validatableResponse.statusCode(200);
 
        // It will check if status line is as expected
        validatableResponse.statusLine("HTTP/1.1 200 OK");
 
        // Check response body - name attribute
        validatableResponse.body("data.name", equalTo("newapitest"));
 
        // Check response body - message attribute
        validatableResponse.body("message", equalTo("Successfully! Record has been added."));
 
    }
}
