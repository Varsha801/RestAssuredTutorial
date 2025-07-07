package First;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class authInHeader {

	 private static final String BASE_URL = "https://httpbin.org/basic-auth/user/pass";
	    private static final String TOKEN = "Basic dXNlcjpwYXNz";
	 
	    @BeforeClass
	    public void setup() {
	        given().baseUri(BASE_URL);
	    }
	 
	    @Test
	    public void validateToken() {
	 
	        Response response = given()
	                .header("Accept", "application/json")
	                .header("Authorization",TOKEN)
	                .contentType(ContentType.JSON)
	                .when()
	                .get("https://httpbin.org/basic-auth/user/pass")
	                .then()
	                .log().all()
	                .extract()
	                .response();
	 
	        assertThat(response.getStatusCode(),equalTo(200));
	 
	    }
}
