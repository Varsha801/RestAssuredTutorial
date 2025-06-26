package First;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.concurrent.TimeUnit;
public class ResponseTime {

	@Test
    public void getResponseTime() {
 
        
 
        // Calling GET method
        Response response = given().when()
                .get("https://reqres.in/api/users/2")
                .then()
                .log().all()
                .extract()
                .response();
        		
        		
 
        // Let's print response body.
        String resString = response.prettyPrint();
        System.out.println("Response Details : " + resString);
 
        //Get Response Time
        System.out.println("Response Time in milliseconds: " + response.getTime());
 
        System.out.println("Response Time in seconds: " + response.getTimeIn(TimeUnit.SECONDS));
 
        System.out.println("Response Time in milliseconds: " + response.time());
 
        System.out.println("Response Time in seconds: " + response.timeIn(TimeUnit.SECONDS));
 
    }
	
	@Test
    public void verifyResponseTime() {
 
        // Given
        given()
 
                // When
                .when()
                .get("https://reqres.in/api/users/2")
 
                // Then
                .then()
                .statusCode(200).statusLine("HTTP/1.1 200 OK")
 
                // Asserting response time is less than 2000 milliseconds
                .time(Matchers.lessThan(3000L));
 
    }
	
	@Test
	public void verifyResponseTimeRange() {
	 
	    // Given
	    given()
	 
	            // When
	            .when()
	            .get("https://reqres.in/api/users/2")
	 
	            // Then
	            .then()
	            .statusCode(200).statusLine("HTTP/1.1 200 OK")
	 
	            // Asserting response time is greater than 1000 milliseconds and less than 2000 milliseconds
	            .time(Matchers.both(Matchers.greaterThanOrEqualTo(1000L)).and(Matchers.lessThanOrEqualTo(2000L)));
	}
}
