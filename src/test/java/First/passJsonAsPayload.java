package First;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

public class passJsonAsPayload {
	
	public PrintStream log ;
    RequestLoggingFilter requestLoggingFilter;
    ResponseLoggingFilter responseLoggingFilter;
	
	@BeforeClass
    public void init() throws FileNotFoundException {
         
         log = new PrintStream(new FileOutputStream("test_logging.txt"),true);  
         requestLoggingFilter = new RequestLoggingFilter(log);
         responseLoggingFilter = new ResponseLoggingFilter(log);
          
    }

	 @Test
	    public void createUser() {
	 
	        // Creating a File instance
	        File jsonData = new File("C:\\Users\\Varsha Narayan\\RestAssured\\RestAssuredTutorial\\src\\test\\resources\\jsonTest.json");
	 
	        // GIVEN
	        given().contentType(ContentType.JSON)
	        .header("x-api-key", "reqres-free-v1")
	        . filters(requestLoggingFilter,responseLoggingFilter)
	        .body(jsonData)
			.when()
				.post("https://reqres.in/api/users")
				
				.then().statusCode(201).log().all();
	 
	    }
	 
	 @Test
	    public void getNumber() {
	 
	        // Creating a File instance
	        File jsonData = new File("C:\\Users\\Varsha Narayan\\RestAssured\\RestAssuredTutorial\\src\\test\\resources\\xmlFile.xml");
	 
	        // GIVEN
	        given()
	        .header("Content-Type", "text/xml")
	        . filters(requestLoggingFilter,responseLoggingFilter)
	        .body(jsonData)
			.when()
				.post("https://www.dataaccess.com/webservicesserver/NumberConversion.wso")
				
				.then().statusCode(200).log().all();
	 
	    }
}
