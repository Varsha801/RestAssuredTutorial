package First;

/*.param() or queryParam(): If you don’t specify which, 
 * REST Assured will assume GET params are query params and POST params are form params.
 */

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;
 
public class ParamDemo {
 
 
    @Test
    public void verifyQueryParam() {
 
        String endpoint = "https://reqres.in/api/";
 
        // Given
        given()
        .header("x-api-key", "reqres-free-v1")        
        .queryParam("page", "2")
 
                // When
                .when()
                .get(endpoint + "users/")
 
                // Then
                .then()
 
                // To verify the response body
                .body("page", equalTo(2))
                .body("per_page", equalTo(6))
                .body("total_pages", equalTo(2));
 
    }
}


