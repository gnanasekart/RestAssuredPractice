package POJOClass;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateEmployeeObject {

	@Test
	public void createEmployeeObjectFromPOJO() throws JsonProcessingException {

		EmployeePojo emp = new EmployeePojo();

		emp.setFirstName("tgs");
		emp.setLastName("name");
		emp.setAge(22);
		emp.setGender("MALE");
		emp.setSalary(100.30);
		emp.setMarried(false);

		ObjectMapper objmap = new ObjectMapper();
		String json= objmap.writerWithDefaultPrettyPrinter().writeValueAsString(emp);

		//System.out.println(json);

		EmployeePojo emppojo = objmap.readValue(json, EmployeePojo.class);
		System.out.println("Firstname = "+emppojo.getFirstName());

		//Json array Payload
		EmployeePojo emp1 = new EmployeePojo();

		emp1.setFirstName("new");
		emp1.setLastName("man");
		emp1.setAge(2);
		emp1.setGender("MALE");
		emp1.setSalary(10.30);
		emp1.setMarried(false);

		EmployeePojo emp2 = new EmployeePojo();

		emp2.setFirstName("old");
		emp2.setLastName("man");
		emp2.setAge(82);
		emp2.setGender("MALE");
		emp2.setSalary(1000.30);
		emp2.setMarried(true);
		
		List<EmployeePojo> list = new ArrayList<EmployeePojo>();
		
		list.add(emp);
		list.add(emp1);
		list.add(emp2);
		
		String arrayEmpList = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(list);
		System.out.println(arrayEmpList);
		
		list.forEach(emplist -> {
			System.out.println("First name = "+emplist.getFirstName());
		});
	}


}
