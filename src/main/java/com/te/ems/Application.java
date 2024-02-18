package com.te.ems;

import java.util.ArrayList;
import java.util.List;

import com.te.ems.entity.Address;
import com.te.ems.entity.BankAccount;
import com.te.ems.entity.Employee;
import com.te.ems.entity.Technology;
import com.te.ems.repository.EmployeeRepository;

public class Application {

	public static void main(String[] args) {

		EmployeeRepository employeeRepository = new EmployeeRepository();

		Address address1 = Address.builder().addressCity("City1").addressState("State1").build();
		Address address2 = Address.builder().addressCity("City2").addressState("State2").build();
		
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address1);
		addresses.add(address2);
		
		
		Technology tech1 = Technology.builder().technologyName("Java").build();
		Technology tech2 = Technology.builder().technologyName("Python").build();
		
		List<Technology> technologies = new ArrayList<Technology>();
		technologies.add(tech1);
		technologies.add(tech2);
		
		BankAccount bankAccount1 = BankAccount.builder().bankIFSC("123FC").bankAccountNumber("12345678").build();
		
		
		
//		Employee employee = Employee.builder()
//				.employeeName("A")
//				.employeeEmailId("j@gmail.com")
//				.bankAccount(bankAccount1)
//				.addresses(addresses)
//				.technologies(technologies)
////				.addresses(List.of(address1,address2))
////				.technologies(List.of(tech1,tech2))
//				.build();
		
		Employee employee = new Employee();
		employee.setEmployeeName("A");
		employee.setEmployeeEmailId("j@gmail.com");
		employee.setAddresses(addresses);
		employee.setTechnologies(technologies);
		employee.setBankAccount(bankAccount1);
		
		
		bankAccount1.setEmployee(employee);
		address1.setEmployee(employee);
		address2.setEmployee(employee);
		
		List<Employee> employees = new ArrayList<Employee>();
		employees.add(employee);
		
//		tech1.setEmployees(List.of(employee));
//		tech2.setEmployees(List.of(employee));
		
		tech1.setEmployees(employees);
		tech2.setEmployees(employees);
		
		int employeeId = employeeRepository.insertEmployee(employee);
		
		System.out.println("Employee saved with ID: " + employeeId);
		
//		Employee e1 = employeeRepository.getEmployeeByID_(1);
//		System.out.println(e1);
//		
//		Employee e2 = employeeRepository.getEmployeeByID(1);
//		System.out.println(e2);
		
//		int addTechnology = employeeRepository.addTechnology(1, "JavaScript");
//		System.out.println(addTechnology);
		
//		int empId = employeeRepository.updateEmployeeEmailIdByEmployeeId(1,"m@gmail.com");
//		
//		System.out.println(empId + " updated");
		
//		employeeRepository.updateCityForEmployee(1,"bangalore");
		
//		List<Employee> employeesList = employeeRepository.listOfEmployeesKnowsTechnology("Angular");
//		if(employeesList == null) System.out.println("not found");
//		else employeesList.forEach(r -> System.out.println(r.getEmployeeName()));
	}
}