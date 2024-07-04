package com.questiontwelve.springbootjpa.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
	public List<Employee> getEmployees(){
		return employeeService.getEmployees();
	}

    @PostMapping
    public void postEmployee(@RequestBody Employee emp){
        employeeService.postEmployee(emp);
    }

    @DeleteMapping(path="{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") Integer id){
        employeeService.deleteEmployee(id);
    }

    @PutMapping
    public void updateEmployee(@RequestBody Employee emp){
        employeeService.updateEmployee(emp);
    }
}
