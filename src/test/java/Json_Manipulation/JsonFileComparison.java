package Json_Manipulation;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class JsonFileComparison {
	
	@Test
    public void compareResponse() throws IOException {
		
		Response response = RestAssured.given().when().get("https://reqres.in/api/users/3").then().extract().response();
		String expectedResponse = response.getBody().asString();
        System.out.println("Response is : " + expectedResponse);
        
     // Path to the JSON file
        File jsonFile = new File("src/test/resources/jsonFile.json");
 
        // Read JSON content from file
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonFromFile = objectMapper.readTree(jsonFile);
        
        JsonNode jsonFromResponse = objectMapper.readTree(expectedResponse);
        
        Assert.assertEquals(jsonFromFile, jsonFromResponse);
        
        // Compare JSON content
        if (jsonFromFile.equals(jsonFromResponse)) {
            System.out.println("JSON from file matches JSON from response");
        } else {
            System.out.println("JSON content does not match");
        }

	}

}
