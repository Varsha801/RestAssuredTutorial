package First;

import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
public class ContentType_Demo {
	
	 @Test
	    public void without_test() {
	 
	        JSONObject data = new JSONObject();
	 
	        data.put("name", "William");
	        data.put("job", "Manager");
	 
	       
	                given()
	                .body(data.toString())
	                .log().all()
	 
	                .when()
	                .post("https://reqres.in/api/users")
	 
	                .then()
	                .assertThat().statusCode(201)
	                .body("name", equalTo("William"))
	                .body("job", equalTo("Manager"))
	                .log().all();
	 
	    }
	 
	 @Test
	    public void with_test() {
	 
	        JSONObject data = new JSONObject();
	 
	        data.put("name", "William");
	        data.put("job", "Manager");
	 
	        
	                given()
	                .contentType(ContentType.JSON)
	                .header("x-api-key", "reqres-free-v1")
	                .body(data.toString())
	                .log().all()
	 
	                .when()
	                .post("https://reqres.in/api/users")
	 
	                .then()
	                .assertThat().statusCode(201)
	                .body("name", equalTo("William"))
	                .body("job", equalTo("Manager"))
	                .log().all();
	 
	    }

}
