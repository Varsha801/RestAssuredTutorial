package Json_Manipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Serialization {
	
	@Test
    public void serializationTest()  {
 
        Employee employee = new Employee();
        employee.setFirstName("Vibha");
        employee.setLastName("Singh");
        employee.setAge(30);
        employee.setSalary(75000);
        employee.setDesignation("Manager");
        employee.setEmailId("abc@test.com");
        employee.setGender("female");
        employee.setMaritalStatus("married");
        ObjectMapper mapper = new ObjectMapper();
        // Converting a Java class object to a JSON payload as string
        try {
            String employeeJson = mapper.writeValueAsString(employee);
            System.out.println(employeeJson);
            String employeePrettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
            System.out.println(employeePrettyJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } 


	}
	
	@Test
    public void SerializationMapTest() {
 
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> inputMap = new HashMap<String, Object>();
 
        inputMap.put("employeeId", "10342256");
        inputMap.put("name", "Vibha Singh");
        inputMap.put("DOB", "12-02-1985");
        inputMap.put("salary", "75000.0");
        inputMap.put("location", "Dublin");
        inputMap.put("contactNumber", "+919999988822");
        inputMap.put("emailId", "abc@test.com");
        inputMap.put("gender", "female");
 
        List<String> skillset = new ArrayList<String>();
 
        skillset.add("Java");
        skillset.add("Teradata");
        skillset.add("Python");
        skillset.add("Power BI");
 
        inputMap.put("skillset", skillset);
 
        // Converting map to a JSON payload as string
        try {
            String employeePrettyJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(inputMap);
            System.out.println(employeePrettyJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
 
        String userDir = System.getProperty("user.dir");
 
        //Writing JSON on a file
        try {
            mapper.writerWithDefaultPrettyPrinter()
                    .writeValue(new File(userDir + "\\src\\test\\resources\\JSONFromMap.json"), inputMap);
        } catch (IOException e) {
            e.printStackTrace();
        }
 
    }
}

