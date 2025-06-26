package First;
import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.annotations.Test;

public class RestAssured_SOAPDemo {
	
	@Test
	public void getSubNumber() {
		File soapData = new File("C:\\Users\\Varsha Narayan\\RestAssured\\RestAssuredTutorial\\src\\test\\resources\\Number.xml");
		
		given().header("Content-Type", "text/xml")
		.body(soapData)
		.post("http://www.dneonline.com/calculator.asmx")
		.then()
		.log().all().assertThat().statusCode(200);
	}

}
