package First;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

import io.restassured.response.Response;
public class TokenExp {
	
	 
	
	 
	        String token = TokenGeneration.getAccessToken();
	        Response response;
	 
	       @Test
	       public void getResponse() {
	         response = given()
	                .auth().oauth2(token)
	                .when()
	                .get("https://example.com/protected/resource")
	                .then()
	                .statusCode(200)
	                .extract().response();
	 
	        System.out.println("Response: " + response.asString());
	    }
	
}
