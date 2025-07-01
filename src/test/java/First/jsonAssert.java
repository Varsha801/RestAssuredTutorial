package First;

import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.testng.annotations.Test;

public class jsonAssert {

	 @Test
	    public void exactSameJson() {
	 
	        String jsonObject1 = "{ " +
	                "\"first_name\" : \"Vibha\"," +
	                "\"last_name\": \"Singh\"" +
	                "}";
	 
	        String jsonObject2 = "{ " +
	                "\"first_name\" : \"Vibha\"," +
	                "\"last_name\": \"Singh\"" +
	                "}";
	 
	        // Lenient mode - extensible and no strict ordering
	        JSONAssert.assertEquals(jsonObject1, jsonObject2, JSONCompareMode.LENIENT);
	    }
	 
	 @Test
	 public void sameJsonWithDifferentOrder() {
	 
	     String jsonObject1 = "{ " +
	             "\"first_name\" : \"Vibha\"," +
	             "\"last_name\": \"Singh\"" +
	             "}";
	 
	     String jsonObject2 = "{ " +
	             "\"last_name\": \"Singh\"," +
	             "\"first_name\" : \"Vibha\"" +
	             "}";
	 
	    
	     JSONAssert.assertEquals(jsonObject1, jsonObject2, JSONCompareMode.LENIENT);
	 }
}
