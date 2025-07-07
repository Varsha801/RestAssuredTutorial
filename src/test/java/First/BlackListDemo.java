package First;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
 
public class BlackListDemo {
 
    @Test
    public void verifyUser1() {
 
        List headers = new ArrayList<String>();
        headers.add("Accept");
        headers.add("Content-Type");
        
        
 
        // Given
        given()
                .config(RestAssured.config().logConfig(LogConfig.logConfig().blacklistHeader("Accept","Content-Type","Reporting-Endpoints")))
                .log().headers()
 
                // When
                .when()
                .get("https://reqres.in/api/users/2")
 
                // Then
                .then()
                .statusCode(200).statusLine("HTTP/1.1 200 OK")
 
                // To verify booking id at index 3
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver")).log().all()
        
        		//To verify header
        		.header("Content-Type", equalTo("application/json; charset=utf-8"));
    }
 
}



