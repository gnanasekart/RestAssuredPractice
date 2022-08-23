package NestedPojoClass;

import java.util.List;

import org.testng.annotations.Test;

import POJOClass.EmployeePojo;

public class EmployeeNested {


	private String companyName;
	private String companyCity;
	private String companyCEO;
	private List<String> supportedAccount;
	private List<Integer> pincodes;

	List<EmployeePojo> employee;
	List<ContractorsPojo> contractors;
	PFPojo companyPF;

	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyCity() {
		return companyCity;
	}
	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}
	public String getCompanyCEO() {
		return companyCEO;
	}
	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}
	public List<String> getSupportedAccount() {
		return supportedAccount;
	}
	public void setSupportedAccount(List<String> supportedAccount) {
		this.supportedAccount = supportedAccount;
	}
	public List<Integer> getPincodes() {
		return pincodes;
	}
	public void setPincodes(List<Integer> pincode) {
		this.pincodes = pincode;
	}
	public List<EmployeePojo> getEmployee() {
		return employee;
	}
	public void setEmployee(List<EmployeePojo> list) {
		this.employee = list;
	}
	public List<ContractorsPojo> getContractors() {
		return contractors;
	}
	public void setContractors(List<ContractorsPojo> contractors) {
		this.contractors = contractors;
	}
	public PFPojo getCompanyPF() {
		return companyPF;
	}
	public void setCompanyPF(PFPojo companyPF) {
		this.companyPF = companyPF;
	}
}