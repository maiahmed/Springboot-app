package com.ntg.SpringBootApp.serviceLayer;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntg.SpringBootApp.model.Employee;
import com.ntg.SpringBootApp.repository.EmployeeRepository;

@Service
public class EmployeeServLayerImpl implements EmlpoyeeServLayer {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee save(Employee employee) {
		System.out.println("''----------ana f Empl Ser Impl--------------");
		return employeeRepository.save(employee);
	}

	
	
	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@Override
	public void delete(Serializable id) {
		employeeRepository.delete((Long) id);
	}

	@Override
	public Employee getById(Serializable id) {
		return employeeRepository.findOne((Long) id);

	}

}
