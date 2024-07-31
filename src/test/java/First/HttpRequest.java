package First;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HttpRequest {
	int id;
	@Test(priority=1)
	void getUser() {
		
		given().when().get("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	}
	@Test(priority=2)
	void createUser() {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("name", "Varsha");
		data.put("job", "QA Engineer");
		id=given().contentType("application/json").body(data)
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		//.then().statusCode(201).log().all();
	}
	
	@Test(priority=3,dependsOnMethods= {"createUser"})
	void updateData() {
		HashMap<String, String> data = new HashMap<String, String>();
		
		data.put("job", "QA");
		given().contentType("application/json").body(data)
		.when()
			.put("https://reqres.in/api/users/"+id)
			
		.then().statusCode(200).log().all();
	}
	
	@Test(priority=3,dependsOnMethods= {"createUser"})
	void deleteData() {
		given()
		.when().delete("https://reqres.in/api/users/"+id)
		.then().statusCode(204).log().all();;
		
	}

}
