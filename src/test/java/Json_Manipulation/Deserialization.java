package Json_Manipulation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;
import java.io.File;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Deserialization {
	
	@Test
	public void deserializationTest() {
	 
	    Employee employee = new Employee();
	    employee.setFirstName("Tim");
	    employee.setLastName("Tran");
	    employee.setAge(49);
	    employee.setSalary(89000);
	    employee.setDesignation("Manager");
	    employee.setContactNumber("+3538944412341");
	    employee.setEmailId("ttran@test.com");
	    employee.setGender("male");
	    employee.setMaritalStatus("married");
	 
	    // Converting a Java class object to a JSON payload as string
	    ObjectMapper mapper = new ObjectMapper();
	    String employeeJson = null;
	    try {
	        employeeJson = mapper.writeValueAsString(employee);
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	    }
	 
	    // Converting Employee json string to Employee class object
	 
	    try {
	        Employee employee2 = mapper.readValue(employeeJson, Employee.class);
	        System.out.println("First Name of employee : " + employee2.getFirstName());
	        System.out.println("Last Name of employee : " + employee2.getLastName());
	        System.out.println("Age of employee : " + employee2.getAge());
	        System.out.println("Salary of employee : " + employee2.getSalary());
	        System.out.println("Designation of employee : " + employee2.getDesignation());
	        System.out.println("Contact Number of employee : " + employee2.getContactNumber());
	        System.out.println("EmailId of employee : " + employee2.getEmailId());
	        System.out.println("Gender of employee : " + employee2.getGender());
	        System.out.println("Marital Status of employee : " + employee2.getMaritalStatus());
	    } catch (JsonMappingException e) {
	        e.printStackTrace();
	    } catch (JsonProcessingException e) {
	        e.printStackTrace();
	    }
	 
	}
	
	@Test
	public void readJson() {
	  
	    ObjectMapper mapper = new ObjectMapper();
	  
	    // Converting Employee JSON string to Employee class object
	    try {
	          Employee employee2 = mapper.readValue(new File(
	                "C:\\Users\\Varsha Narayan\\RestAssured\\RestAssuredTutorial\\src\\test\\resources\\Employees.json"),
	                Employee.class);
	          System.out.println("First Name of employee : " + employee2.getFirstName());
	          System.out.println("Last Name of employee : " + employee2.getLastName());
	          System.out.println("Age of employee : " + employee2.getAge());
	          System.out.println("Salary of employee : " + employee2.getSalary());
	          System.out.println("Designation of employee : " + employee2.getDesignation());
	          System.out.println("Contact Number of employee : " + employee2.getContactNumber());
	          System.out.println("EmailId of employee : " + employee2.getEmailId());
	          
	    } catch (StreamReadException e) {
	        e.printStackTrace();
	    } catch (DatabindException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	@Test
    public void DeserializationMapTest() throws StreamReadException, DatabindException, IOException {
 
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> outputMap = new HashMap<String, Object>();
        outputMap = mapper.readValue(new File(
                "C:\\Users\\Varsha Narayan\\RestAssured\\RestAssuredTutorial\\src\\test\\resources\\JSONFromMap.json"),
        		 new TypeReference<Map<String, Object>>(){});
        
        System.out.println("Gender : " + outputMap.get("gender"));
        System.out.println("DOB : " + outputMap.get("DOB"));
        System.out.println("Name : " + outputMap.get("name"));
        System.out.println("ContactNumber : " + outputMap.get("contactNumber"));
        System.out.println("SkillSet : " + outputMap.get("skillset"));
        
	}

}
