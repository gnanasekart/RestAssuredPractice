package NestedPojoClass;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;
import POJOClass.EmployeePojo;

public class CreatedNestFromPojo {

	@Test
	public void cerateNestedJson() throws IOException {
		
		EmployeeNested empNested = new EmployeeNested();
		
		empNested.setCompanyName("Ten");
		empNested.setCompanyCity("chennai");
		empNested.setCompanyCEO("DAN");
		
		//create salary details and add into supportedAccounts array
		List<String> salaryAccounts = new ArrayList<String>();
		salaryAccounts.add("HDFC");
		salaryAccounts.add("ICICI");
		salaryAccounts.add("AXIS");
		empNested.setSupportedAccount(salaryAccounts);
		
		//add into pincode array
		List<Integer> pincode = new ArrayList<Integer>();
		pincode.add(560000);
		pincode.add(123456);
		pincode.add(345666);
		empNested.setPincodes(pincode);
		
		//add into employee array
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
		
		list.add(emp2);
		list.add(emp1);
		empNested.setEmployee(list);
		
		//add contractors array
		
		ContractorsPojo cpemp = new ContractorsPojo();
		cpemp.setFirstname("marina");
		cpemp.setLastname("l");
		cpemp.setContractFrom("Nov");
		cpemp.setContractTo("Apl");
		
		ContractorsPojo cpemp1 = new ContractorsPojo();
		cpemp1.setFirstname("chrinst");
		cpemp1.setLastname("c");
		cpemp1.setContractFrom("Nov");
		cpemp1.setContractTo("Apl");
		
		List<ContractorsPojo> contEmp = new ArrayList<ContractorsPojo>();
		contEmp.add(cpemp);
		contEmp.add(cpemp1);
		empNested.setContractors(contEmp);
		
		//pf details
		PFPojo pf = new PFPojo();
		pf.setpFName("xyz");
		pf.setPfcity("BAN");
		pf.setNoOfEmployees(100);
		pf.setPfyear(2022);
		empNested.setCompanyPF(pf);
		
		String content = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(empNested);
		System.out.println(content);
		
		//write the json content into a file
		File file = new File("target/nestedPojo.json");
		file.createNewFile();
		new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(file, empNested);
	}
}
