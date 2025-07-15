package Json_Manipulation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class NestedPOJOTest {
	
	@Test
    public void createNestedPOJO() throws IOException {
 
        NestedPOJODemo demo = new NestedPOJODemo();
        demo.setCompanyName("QAAutomation");
        demo.setCompanyEmailId("qaautomation@org.com");
        demo.setCompanyNumber("+353891234121");
        demo.setCompanyAddress("12, HeneryStreet, Dublin, D12PW20");
 
        List<String> supportedSalaryBanks = new ArrayList<String>();
        supportedSalaryBanks.add("AIB");
        supportedSalaryBanks.add("BOI");
        supportedSalaryBanks.add("PSB");
        demo.setSupportedSalaryBanks(supportedSalaryBanks);
 
        // First Employee
        Employee emp1 = new Employee();
        emp1.setFirstName("Vibha");
        emp1.setLastName("Singh");
        emp1.setAge(30);
        emp1.setSalary(75000);
        emp1.setDesignation("Manager");
        emp1.setContactNumber("+919999988822");
        emp1.setEmailId("abc@test.com");
 
        // Second Employee
        Employee emp2 = new Employee();
        emp2.setFirstName("Neha");
        emp2.setLastName("Verms");
        emp2.setAge(35);
        emp2.setSalary(60000);
        emp2.setDesignation("Lead");
        emp2.setContactNumber("+914442266221");
        emp2.setEmailId("xyz@test.com");
 
        // Third Employee
        Employee emp3 = new Employee();
        emp3.setFirstName("Rajesh");
        emp3.setLastName("Gupta");
        emp3.setAge(20);
        emp3.setSalary(40000);
        emp3.setDesignation("Intern");
        emp3.setContactNumber("+919933384422");
        emp3.setEmailId("pqr@test.com");
 
        // Creating a List of Employees
        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(emp1);
        employeeList.add(emp2);
        employeeList.add(emp3);
        demo.setEmployee(employeeList);
 
        // First Contractor
        Cotractors contractor1 = new Cotractors();
        contractor1.setFirstName("John");
        contractor1.setLastName("Mathew");
        contractor1.setContractFrom("Jan-2018");
        contractor1.setContractTo("Aug-2022");
        contractor1.setContactNumber("+919631384422");
 
        // Second Contractor
        Cotractors contractor2 = new Cotractors();
        contractor2.setFirstName("Seema");
        contractor2.setLastName("Mathew");
        contractor2.setContractFrom("Jun-2019");
        contractor2.setContractTo("Jun-2023");
        contractor2.setContactNumber("+919688881422");
 
        // Creating a List of Contractors
        List<Cotractors> contractorList = new ArrayList<Cotractors>();
        contractorList.add(contractor1);
        contractorList.add(contractor2);
        demo.setContractors(contractorList);
 
        CompanyPFDetails pf = new CompanyPFDetails();
        pf.setPfName("XYZ");
        pf.setPfYear(2020);
        pf.setNoOfEmployees(100);
        demo.setCompanyPFDetails(pf);
        
        ObjectMapper mapper = new ObjectMapper();
        String nestedJson = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(demo);
        System.out.println(nestedJson);
        
        String userDir = System.getProperty("user.dir");
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(userDir + "\\src\\test\\resources\\NestedEmployeePayload.json"), demo);
            

	}
}
