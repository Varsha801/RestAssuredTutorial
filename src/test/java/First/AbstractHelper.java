package First;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AbstractHelper {
	
	  String token;
	   String accessToken;
	   JsonPath jsonPath;
	   Response response;
	 
	    public String generateToken() throws IOException {
	 
	        String username = null;
			String password = null;
			token = given().auth().preemptive()
	                .basic(username, password)
	                .contentType("application/x-www-form-urlencoded")
	                .formParam("grant_type", "client_credentials")
	                .when().post("https://example.com/accesstoken").asString();
	 
	        System.out.println("Token :" + token);
	 
	        jsonPath = new JsonPath(token);
	        accessToken = jsonPath.getString("access_token");
	        System.out.println("Access Token :" + accessToken);
	        return accessToken;
	    }
	    
	    
	     
	    @Test
	     public void testRequest() throws IOException {
	  
	         response = RestAssured.given()
	                 .auth().oauth2(generateToken())
	                 .when().get("https://localhost/8080/coreid").then()
	                 .extract()
	                 .response();
	  
	         System.out.println("Response :" + response.asString());
	         int statusCode = response.getStatusCode();
	  
	         Assert.assertEquals(200,statusCode);
	     }

}
