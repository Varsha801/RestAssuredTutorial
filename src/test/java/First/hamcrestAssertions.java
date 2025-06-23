package First;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;

public class hamcrestAssertions {

	public String endpoint = "https://restful-booker.herokuapp.com/booking/1";
	 
    @Test
    public void numberAssertions() {
        given().contentType(ContentType.JSON)
                .when().get(endpoint).then()
                .body("totalprice", equalTo(111));
 
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("totalprice",greaterThan(100));
 
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("totalprice",greaterThanOrEqualTo(50));
 
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("totalprice",lessThan(1000));
 
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("totalprice",lessThanOrEqualTo(1000));
 
    }
    
    @Test
    public void stringAssertions() {
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("firstname",equalTo("Mary"));
 
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("firstname",equalToIgnoringCase("mary"));
 
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("firstname",containsString("James"));
 
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("firstname",startsWith("J"));
 
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("firstname",endsWith("s"));
 
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("firstname",equalToCompressingWhiteSpace("   James "));
 
 
    }
    
    @Test
    public void nullAssertion() {
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("totalprice1", is(nullValue()));
    }
    
    @Test
    public void collectionAssertions() {
 
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("bookingdates",hasKey("checkin"));
 
    }
    
    @Test
    public void negativeAssertions() {
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("totalprice",not(equalTo(874)));
 
    }
    
    @Test
    public void test1() {
        given().contentType(ContentType.JSON)
                .when().get(endpoint).then()
                .body("firstname", equalTo("Jim"), // will fail
                        "lastname", equalTo("Smith"), // will fail
                        "totalprice", equalTo(314)); // will fail
    }
}
