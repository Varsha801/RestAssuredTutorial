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
                .then().body("firstname",equalTo("new_name"));
 
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("firstname",equalToIgnoringCase("NEW_name"));
 
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("firstname",containsString("new"));
 
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("firstname",startsWith("n"));
 
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("firstname",endsWith("e"));
 
        given().contentType(ContentType.JSON)
                .when().get(endpoint)
                .then().body("firstname",equalToCompressingWhiteSpace("   new_name "));
 
 
    }
}
