package com.soori.java8.stream;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8StreamExample {

	public static void main(String[] args) {
		List<Employee> employees = getEmployeeList();

		// Example 1: Filter employees by branch
		List<Employee> itEmployees = employees.stream().filter(e -> "IT".equals(e.getEBranch()))
				.collect(Collectors.toList());
		System.out.println("IT Employees: " + itEmployees);

		// Example 2: Map employee names to a list
		List<String> employeeNames = employees.stream().map(Employee::getEName).collect(Collectors.toList());
		System.out.println("Employee Names: " + employeeNames);

		// Example 3: Get all addresses of employees
		List<Address> allAddresses = employees.stream().flatMap(e -> e.getAddresses().stream())
				.collect(Collectors.toList());
		System.out.println("All Addresses: " + allAddresses);

		// Example 4: Find employees with salary greater than 55000
		List<Employee> highSalaryEmployees = employees.stream().filter(e -> e.getESal() > 55000)
				.collect(Collectors.toList());
		System.out.println("High Salary Employees: " + highSalaryEmployees);

		// Example 5: Sort employees by name
		List<Employee> sortedEmployees = employees.stream().sorted((e1, e2) -> e1.getEName().compareTo(e2.getEName()))
				.collect(Collectors.toList());
		System.out.println("Sorted Employees: " + sortedEmployees);

		// Example: Get Employee ID and its Address List
		Map<Integer, List<Address>> collect = employees.stream()
				.collect(Collectors.toMap(Employee::getEid, Employee::getAddresses));
		collect.forEach(Java8Util.eIdAdressConsumer);
		
		Function<List<Address>, Address> getPrimaryAddress = addressList -> addressList.stream()
				.filter(Address::isPrimary).findFirst().get();

		// Get Map<EmployeeId, PrimaryAddress>
		Map<Integer, Address> employeePrimaryAddressMap = employees.stream()
				.collect(Collectors.toMap(Employee::getEid, e -> getPrimaryAddress.apply(e.getAddresses())));

	    Function<Integer, String> intToString = String::valueOf;
		employees.stream().map(e -> String.valueOf(e.getEid())).collect(Collectors.joining(","));
		employees.stream().map(Employee::getEid).map(intToString).collect(Collectors.joining(","));
		
		//Split iterator
		Spliterator<Employee> spliteratorEmps = employees.stream().spliterator();
		System.out.println("spliteratorEmps "+spliteratorEmps.estimateSize());//3 employees
		
		Spliterator<Employee> spliteratorEmpsPart2 = spliteratorEmps.trySplit();
		System.out.println("spliteratorEmps "+spliteratorEmps.estimateSize());//2 employees
		System.out.println("spliteratorEmpsPart2 "+spliteratorEmpsPart2.estimateSize());//1 employees
		
	}

	private static List<Employee> getEmployeeList() {
		return Arrays.asList(
				new Employee(1, "John Doe", 50000, LocalDate.of(1985, 5, 15), "IT",
						Arrays.asList(
								new Address("123", "Main St", "Downtown", "CityA", "StateA", "123456", "home", true),
								new Address("124", "Second St", "Uptown", "CityA", "StateA", "123457", "office",
										false))),
				new Employee(2, "Jane Smith", 60000, LocalDate.of(1990, 8, 20), "HR",
						Arrays.asList(
								new Address("456", "Second St", "Uptown", "CityB", "StateB", "654321", "home", true),
								new Address("457", "Third St", "Midtown", "CityB", "StateB", "654322", "office",
										false))),
				new Employee(3, "Emily Davis", 70000, LocalDate.of(1982, 11, 25), "Finance", Arrays.asList(
						new Address("789", "Third St", "Midtown", "CityC", "StateC", "789123", "home", true),
						new Address("790", "Fourth St", "Downtown", "CityC", "StateC", "789124", "office", false))));
	}
}
