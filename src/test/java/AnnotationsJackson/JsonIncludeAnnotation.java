package AnnotationsJackson;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonIncludeAnnotation {
	@Test
	public void avoidDeafultvalues() throws JsonProcessingException {

		EmployeePojo employee = new EmployeePojo();

		employee.setFirstName("Amod");
		employee.setLastName("Mahajan");
		employee.setSalary(3434343);
		employee.setMarried(true);

		System.out.println(new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(employee));

		/*
		 * 
		 * {
			  "lastName" : "Mahajan",
			  "married" : true,
			  "firstName" : "Amod",
			  "salary" : 3434343.0,
			  "age" : 0,
			  "gender" : null
			}
		 */
	}

}
