package First;

import org.json.JSONObject;
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
	 
	 @Test
	 public void sameJsonWithDifferentValues() {
	  
	     String jsonObject1 = "{ " +
	             "\"first_name\" : \"Vibha\"," +
	             "\"last_name\": \"Singh\"" +
	             "}";
	  
	     String jsonObject2 = "{ " +
	             "\"first_name\" : \"Vibha\"," +
	             "\"last_name\": \"Verma\"" +
	             "}";
	  
	     JSONAssert.assertEquals(jsonObject1, jsonObject2, JSONCompareMode.LENIENT);
	 }
	 
	 @Test
	  public void sameJsonWithDifferentDataType() {
	 
	      String jsonObject1 = "{ " +
	              "\"first_name\" : \"Vibha\"," +
	              "\"last_name\": \"Singh\"," +
	              "\"salary\": 115000" +
	              "}";
	 
	      String jsonObject2 ="{ " +
	              "\"first_name\" : \"Vibha\"," +
	              "\"last_name\": \"Singh\"," +
	              "\"salary\": \"115000\"" +
	              "}";
	 
	      JSONAssert.assertEquals(jsonObject1, jsonObject2, JSONCompareMode.LENIENT);
	  }
	 
	 @Test
	   public void differentJson() {
	 
	       String jsonObject1 = "{ " +
	               "\"first_name\" : \"Vibha\"," +
	               "\"last_name\": \"Singh\"" +
	               "}";
	 
	       String jsonObject2 ="{ " +
	               "\"first_name\" : \"Vibha\"," +
	               "\"last_name\": \"Singh\"," +
	               "\"salary\": \"115000\"" +
	               "}";
	 
	       JSONAssert.assertEquals(jsonObject1, jsonObject2, JSONCompareMode.LENIENT);
	       System.out.println("First Assert passed");
	       JSONAssert.assertEquals(jsonObject2, jsonObject1, JSONCompareMode.LENIENT);
	   }
	 
	 @Test
	  public void differentJsonWithStrict() {
	 
	      String jsonObject1 = "{ " +
	              "\"first_name\" : \"Vibha\"," +
	              "\"last_name\": \"Singh\"" +
	              "}";
	 
	      String jsonObject2 ="{ " +
	              "\"first_name\" : \"Vibha\"," +
	              "\"last_name\": \"Singh\"," +
	              "\"salary\": \"115000\"" +
	              "}";
	 
	      JSONAssert.assertEquals("JSONs are not equal",jsonObject1, jsonObject2, JSONCompareMode.STRICT);
	  }
	 
	 @Test
	   public void matchJsonObject()  {
	 
	       JSONObject jsonObject1 = new JSONObject();
	       jsonObject1.put("first_name", "Vibha");
	       jsonObject1.put("last_name", "Singh");
	 
	       JSONObject jsonObject2 = new JSONObject();
	       jsonObject2.put("first_name", "Vibha");
	       jsonObject2.put("last_name", "Verma");
	 
	       JSONAssert.assertEquals("JSONs are not equal", jsonObject1, jsonObject2, false);
	   }
}
