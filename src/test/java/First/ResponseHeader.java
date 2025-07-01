package First;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;
public class ResponseHeader {
	 @Test
	    public void verifyResponseHeader() {
	 
	      // Given
	      given()
	 
	              // When
	              .when()
	              .get("https://reqres.in/api/users/2")
	 
	              // Then
	              .then()
	              .statusCode(200).statusLine("HTTP/1.1 200 OK")
	              .log().all()
	              .header("Content-Type" , "application/json; charset=utf-8")
	              .header("Content-Encoding" , "gzip")
	              .header("Server" , containsString("cloudflare"));
	 
	    }
	 
	 @Test
	  public void verifySoftAssertion() {
	 
	      // Given
	      given()
	 
	              // When
	              .when()
	              .get("https://reqres.in/api/users/2")
	 
	              // Then
	              .then()
	 
	              // To verify the response body
	              .body("data.email", equalTo("janet.weaver@reqres12.in"),
	                        "data.first_name", equalTo("Janet1"),
	                        "data.last_name", equalTo("Weaver"));
	 
	    }

}
