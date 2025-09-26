package First;

import org.json.JSONArray;
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
	 @Test
	   public void jsonArray() {
	 
	       JSONObject data1 = new JSONObject();
	       data1.put("first_name", "Vibha");
	       data1.put("last_name", "Singh");
	 
	       JSONObject data2 = new JSONObject();
	       data2.put("first_name", "Nysha");
	       data2.put("last_name", "Verma");
	 
	 
	       // Creating JSON array to add both JSON objects
	       JSONArray array1 = new JSONArray();
	       array1.put(data1);
	       array1.put(data2);
	 
	       System.out.println("JSON Array :" + array1);
	 
	      //Second JSON Array
	 
	       JSONObject data3 = new JSONObject();
	       data3.put("first_name", "Nysha");
	       data3.put("last_name", "Verma");
	 
	       JSONObject data4 = new JSONObject();
	       data4.put("first_name", "Vibha");
	       data4.put("last_name", "Singh");
	 
	       // Creating JSON array to add both JSON objects
	       JSONArray array2 = new JSONArray();
	       array2.put(data3);
	       array2.put(data4);
	 
	       System.out.println("JSON Array :" + array2);
	 
	       JSONAssert.assertEquals(array1, array2, JSONCompareMode.STRICT);
	   }
}
