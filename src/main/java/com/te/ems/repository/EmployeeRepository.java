package com.te.ems.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.te.ems.entity.Address;
import com.te.ems.entity.Employee;
import com.te.ems.entity.Technology;

public class EmployeeRepository {

	private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MySQL01");
	private EntityManager entityManager = entityManagerFactory.createEntityManager();

	// Insert, Update, Delete - Should be packed under a transaction
	// TODO: to create a method that inserts employee data in the database

	public int insertEmployee(Employee employee) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(employee); // or merge
		entityTransaction.commit();
		return employee.getEmployeeId();
	}

	// TODO : create a method to get employee data from database
	// getReference() will check the cache memory first before hitting the DB
	public Employee getEmployeeByID(int employeeId) {
		Employee employee = entityManager.getReference(Employee.class, employeeId);
		return employee;
	}

	// find() hits the DB directly
	public Employee getEmployeeByID_(int empid) {
		Employee employee = entityManager.find(Employee.class, empid);
		return employee;
	}

	// Get + Insert API = Update API
	// TODO : add technology
	public int addTechnology(int employeeId, String technologyName) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Employee employeeFromDB = entityManager.getReference(Employee.class, employeeId);
		employeeFromDB.getTechnologies().add(Technology.builder().technologyName(technologyName).build());
		entityManager.persist(employeeFromDB);
		entityTransaction.commit();
		return employeeFromDB.getEmployeeId();
	}

	// TODO : update EmployeeEmailIdByEMployeeId

	public int updateEmployeeEmailIdByEmployeeId(int employeeId, String employeeEmailId) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Employee employee = entityManager.getReference(Employee.class, employeeId);
		employee.setEmployeeEmailId(employeeEmailId);
		entityManager.persist(employee);
		entityTransaction.commit();
		return employee.getEmployeeId();
	}

	// TODO : updates city for a particular employee providing old and new city
	// names
	public void updateCityForEmployee(int employeeId, String oldCityName, String newCityName) {

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();

		Employee employee = entityManager.getReference(Employee.class, employeeId);
		List<Address> addresses = employee.getAddresses();

		for (Address address : addresses) {
			// System.out.println(address.getAddressCity());
			if (address.getAddressCity().equalsIgnoreCase(oldCityName))
				address.setAddressCity(newCityName);
		}
		entityManager.persist(employee);
		entityTransaction.commit();

	}

	// TODO : find list of employees who know java
	public List<Employee> listOfEmployeesKnowsTechnology(String technologyName) {

		Technology technology = entityManager.find(Technology.class, technologyName);
		if (technology == null)
			return null;
		return technology.getEmployees();

	}

	// TODO : updates city for a particular employee using employeeId
	public void updateCityForEmployee(int employeeId, String newCityName) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Employee employee = entityManager.getReference(Employee.class, entityTransaction);
		List<Address> addresses = employee.getAddresses();
		for (Address address : addresses) {
			if (employee.getEmployeeId() == employeeId) {
				address.setAddressCity(newCityName);
			}
		}
		entityManager.persist(employee);
		entityTransaction.commit();
	}

	// TODO: delete technology

}
