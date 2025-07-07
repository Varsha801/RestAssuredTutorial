package First;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class Validations {
	
	@Test
    public void verifyStatusCode() {
 
        String BaseURL = "https://dummy.restapiexample.com/api";
 
        // GIVEN
       Response response =  given()
 
                // WHEN
                .when()
                .get("https://reqres.in/api/users/2")
 
                // THEN
                .then()
               .extract().response();
 
       int actualStatusCode = response.getStatusCode();
       System.out.println("Status Code : " + actualStatusCode);
 
        Assert.assertEquals(200, actualStatusCode);
 
    }
	
	@Test
	   public void verifyStatusLine() {
	 
	       // GIVEN
	       Response response =  given()
	 
	               // WHEN
	               .when()
	               .get("https://reqres.in/api/users/2")
	 
	               // THEN
	               .then()
	               .extract().response();
	 
	       String actualStatusLine = response.getStatusLine();
	       System.out.println("Status Line : " + actualStatusLine);
	 
	       Assert.assertEquals("HTTP/1.1 200 OK", actualStatusLine);
	 
	   }
	
	@Test
	  public void verifyResponseBody() {
	 
	      // GIVEN
	      Response response =  given()
	 
	              // WHEN
	              .when()
	              .get("https://reqres.in/api/users/2")
	 
	              // THEN
	              .then()
	              .extract().response();
	 
	      String actualResponseBody = response.getBody().asString();
	      System.out.println("Response Body : " + actualResponseBody);
	 
	      JsonPath jsonPath = response.jsonPath();
	      String actualResponse_Id = jsonPath.getString("data.id");
	      System.out.println("Response Id : " + actualResponse_Id);
	 
	      Assert.assertEquals("2", actualResponse_Id);
	 
	  }
	
	@Test
	   public void verifyContentType() {
	 
	       // GIVEN
	       Response response =  given()
	 
	               // WHEN
	               .when()
	               .get("https://reqres.in/api/users/2")
	 
	               // THEN
	               .then()
	               .extract().response();
	 
	       String actualContentType = response.getContentType();
	       System.out.println("Actual ContentType : " + actualContentType);
	 
	        Assert.assertEquals("application/json; charset=utf-8", actualContentType);
	 
	   }

}
