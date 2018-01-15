package com.ntg.SpringBootApp.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ntg.SpringBootApp.model.Employee;
import com.ntg.SpringBootApp.model.Services;
import com.ntg.SpringBootApp.serviceLayer.EmployeeServLayerImpl;
import com.ntg.SpringBootApp.serviceLayer.ServiceServLayerImpl;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class EmployeeController {
	
	@Autowired
	EmployeeServLayerImpl empServ ;
	
	@Autowired
	ServiceServLayerImpl serviceServ;
	
	
	 @RequestMapping( method = RequestMethod.POST, value = "emp/" )
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
		 System.out.println("------I'm in Add------------");
			System.out.println("------------------+++ " + employee.getFirstName()+" "+ employee.getLastName()+" "+employee.getId());

		employee = empServ.save(employee);
		return new ResponseEntity<Employee>(employee, HttpStatus.CREATED);

	}
	 
	 @RequestMapping(value = "emp/{id}", method = RequestMethod.GET)
		public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long id) {
			Employee employee = empServ.getById(id);
			
			if(employee == null ){
				return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);

		}
	 
	 @RequestMapping(method = RequestMethod.GET, value = "/emp")
		public ResponseEntity<List<Employee>> getAllEmployees() {
			List<Employee> employees = empServ.getAll();
			if (employees.isEmpty()) {
				System.out.println("----- Employees does not exists -------");
				return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
			}
			System.out.println("Found " + employees.size() + " Employees");
			System.out.println(employees);
			System.out.println(Arrays.toString(employees.toArray()));
			return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
		}

		
		@RequestMapping(method = RequestMethod.POST, value = "/serv")
		public ResponseEntity<Services> addService(@RequestBody Services service) {
			System.out.println("------I'm in Add Ser------------");
			System.out.println("------------------+++ " + service);

			service = serviceServ.save(service);
			return new ResponseEntity<Services>(service, HttpStatus.CREATED);

		}

		@RequestMapping(value = "serv/{id}", method = RequestMethod.GET)
		public ResponseEntity<Services> getService(@PathVariable("id") Long id) {
			Services services = serviceServ.getById(id);

			if (services == null) {
				return new ResponseEntity<Services>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<Services>(services, HttpStatus.CREATED);

		}

		@RequestMapping(method = RequestMethod.GET, value = "/serv")
		public ResponseEntity<List<Services>> getAllServices() {
			List<Services> servicesList = serviceServ.getAll();
			if (servicesList.isEmpty()) {
				System.out.println("----- ServicesList does not exists -------");
				return new ResponseEntity<List<Services>>(HttpStatus.NO_CONTENT);
			}
			System.out.println("Found " + servicesList.size() + " Sercvices");
			System.out.println(servicesList);
			return new ResponseEntity<List<Services>>(servicesList, HttpStatus.OK);
		}
}
