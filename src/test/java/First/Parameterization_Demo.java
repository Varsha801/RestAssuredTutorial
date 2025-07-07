package First;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Parameterization_Demo {
	
	@DataProvider
    public static Object[][] responseData() {
        return new Object[][] {
                { "1", "George", "Bluth" },
                { "2", "Janet", "Weaver" },
                { "3", "Emma", "Wong" },
                { "4", "Eve", "Holt" }
        };
    }
	
	@Test(dataProvider = "responseData")
	public void verifyResponse(String id, String expectedFirstName, String expectedLastName)
    {
        given().
                when().
                pathParam("id", id).
                get("https://reqres.in/api/users/{id}").
                then().
                assertThat().
                statusCode(200).
                body("data.first_name", equalTo(expectedFirstName)).
                body("data.last_name", equalTo(expectedLastName));
    }

}
