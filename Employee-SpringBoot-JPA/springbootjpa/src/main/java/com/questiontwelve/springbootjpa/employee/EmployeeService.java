package com.questiontwelve.springbootjpa.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
	private EmployeeRepository repository;

	@Autowired
	public EmployeeService(EmployeeRepository repository) {
		this.repository = repository;
	}

	public List<Employee> getEmployees(){
		return repository.findAll();
	}

	public void postEmployee(Employee emp){
		repository.save(emp);
	}

	public void deleteEmployee(Integer id){
		repository.deleteById(id);
	}

	@Transactional
	public void updateEmployee(Employee emp) {
		Employee databaseEmp = repository.findById(emp.getId())
			.orElseThrow(() -> new RuntimeException("Employee not found with id: " + emp.getId()));

		databaseEmp.setName(emp.getName());
		databaseEmp.setDepartment(emp.getDepartment());

		repository.save(databaseEmp);
	}
}
