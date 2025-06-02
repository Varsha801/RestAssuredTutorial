package First;
import static io.restassured.RestAssured.*;


import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.CoreMatchers.equalTo;
public class HttpRequest {
	int id;
	ValidatableResponse validatableResponse;
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
	
	 @Test
	    public void createUser2() {
	 
	        String json = "{\"name\":\"apitest\",\"salary\":\"5000\",\"age\":\"30\"}";
	 
	        // GIVEN
	        validatableResponse = given()
	                .baseUri("https://dummy.restapiexample.com/api")
	                .contentType(ContentType.JSON)
	                .body(json)
	 
	                // WHEN
	                .when()
	                .post("/v1/create")
	 
	                // THEN
	                .then()
	                .statusCode(200).body("data.name", equalTo("apitest"))
	                .body("message", equalTo("Successfully! Record has been added."));
	 
	        System.out.println("Response :" + validatableResponse.extract().asPrettyString());
	    }
	 
	 @Test
	 public void updateUser2() {
		 
		 String jsonString = "{\"id\": 2,\r\n"
	                + "        \"employee_name\": \"Garrett Winters\",\r\n"
	                + "        \"employee_salary\": 99999,\r\n"
	                + "        \"employee_age\": 63,\r\n"
	                + "        \"profile_image\": \"\"}";
		
		 given().contentType(ContentType.JSON).body(jsonString).when()
		 .put("https://dummy.restapiexample.com/api/v1/update/2")
		 .then()
		 .statusCode(200).log().all();
	 }
	 
	 @Test
	 public void deleteUser2() {
		 given().when().delete("https://dummy.restapiexample.com/api/v1/delete/3").then().statusCode(200).log().all();
	 }
	 
	 
	 @Test
	 public void patchRequest() {
		 String jsonString = "{\"name\": \"William\"}";
		 given().contentType(ContentType.JSON)
		 .header("x-api-key", "reqres-free-v1")
		 .body(jsonString).when().patch("https://reqres.in/api/users/2")
		 .then()
		 .statusCode(200).log().all();
		 
//		 String jsonString = "{\"name\": \"William\"}";
//		 
//	        // Update name
//	        validatableResponse = given()
//	                .baseUri("https://reqres.in/api/users/2")
//	                .contentType(ContentType.JSON)
//	                .body(jsonString)
//	                .when()
//	                .patch()
//	                .then()
//	                .assertThat().statusCode(200)
//	                .body("name", equalTo("William"));
//	 
//	        System.out.println("Response :" + validatableResponse.extract().asPrettyString());
	 
	 }
	 
	 @Test
	 public void postJsonObj() {
		 
//		 JSONObject data = new JSONObject();
//		 
//		    data.put("profile_image", "test.png");
//		         
//		    //Second JSONObject
//		    JSONObject detail = new JSONObject();
//		 
//		    detail.put("updated_message", "Details of New Resource");
//		    detail.put("employee_age", "30");
//		 
//		    data.put("employee_details", detail);
//		 
//		    data.put("employee_name", "MapTest");
//		    data.put("employee_salary", "11111");
		 
		 Map<String, Object> data = new HashMap<String, Object>();
	        data.put("employee_name", "MapTest");
	        data.put("profile_image", "test.png");
	 
	        // Second JSON Object using Hash Map
	        Map<String, String> msg = new HashMap<String, String>();
	        msg.put("updated_message", "Details of New Resource");
	        msg.put("employee_age", "30");
	        data.put("details", msg);
	        data.put("employee_salary", "99999");
		 given()
		 .contentType(ContentType.JSON)
		 .body(data)
		 .when()
		 .post("http://dummy.restapiexample.com/api/v1/create")
		 .then()
		 .statusCode(200).log().all();
	 }
	 
	 @Test
	 public void jsonArrayPost() {
		 JSONObject data1 = new JSONObject();
		 
	        data1.put("employee_name", "ObjectTest");
	        data1.put("profile_image", "test1.png");
	        data1.put("employee_age", "30");
	        data1.put("employee_salary", "11111");
	 
	        // JSON Object for second employee
	        JSONObject data2 = new JSONObject();
	 
	        data2.put("employee_name", "MapTest");
	        data2.put("profile_image", "test2.png");
	        data2.put("employee_age", "20");
	        data2.put("employee_salary", "99999");
	 
	        // Creating JSON array to add both JSON objects
	        JSONArray array = new JSONArray();
	        array.put(data1);
	        array.put(data2);
	        
	        given()
			 .contentType(ContentType.JSON)
			 .body(array.toString())
			 .when()
			 .post("http://dummy.restapiexample.com/api/v1/create")
			 .then()
			 .statusCode(200).log().all();
	        
	 }

}
