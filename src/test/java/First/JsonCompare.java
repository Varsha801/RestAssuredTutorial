package First;

import java.io.IOException;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
public class JsonCompare {
	
	@Test
    public void verifyGreaterResponseTime() throws IOException {
 
        // Given
        given()
 
                // When
                .when()
                .get("https://reqres.in/api/users/3")
 
                // Then
                .then()
 
                .assertThat()
                .body(matchesJsonSchemaInClasspath("Users.json"));
    }

}
