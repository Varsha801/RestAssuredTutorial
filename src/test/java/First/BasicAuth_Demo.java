package First;

import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
public class BasicAuth_Demo {
	
	private String validRequest = "{" +
	           "\"username\": \"Samu01\"," +
	           "\"email\": \"samuel@email.com\"," +
	           "\"password\": \"Passw0rd123!\"" +
	           "}";
	
	
	@Test
    public void validateCredentials() {
 
        Response response = given()
                .auth()
                //.preemptive()
                .basic("user", "pass")
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .when()
                .get("https://httpbin.org/basic-auth/user/pass")
                .then()
                .log().all()
                .extract()
                .response();
 
        int statusCode = response.getStatusCode();
 
        Assert.assertEquals(200,statusCode);
    }
	
	//Just an example will not work 
	@Test
    public void createUser() {
        Response response = given()
                .auth()
                .preemptive()
                .basic("username", "password")
                .header("Accept", "application/json")
                .contentType(ContentType.JSON)
                .body(validRequest)
                .when()
                .post("http://localhost:8080/users")
                .then()
                .extract()
                .response();
 
        int statusCode = response.getStatusCode();
 
        Assert.assertEquals(statusCode,200);
    }

}
