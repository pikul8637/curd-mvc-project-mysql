package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeMgmtService;

@Controller
public class EmployeeOperationsController {
@Autowired
private IEmployeeMgmtService empService;

@GetMapping("/")
public String showHomePage() {
	//return LVN
	return"welcome";
}
@GetMapping("/report")
public String generateReport(Map<String,Object> map) {
	//use service
	Iterable<Employee> it=empService.showAllEmployees();
	//keep the result in model attribute(shared memory)
	map.put("empList",it);
	//return LVN
	return "show_report";
	
}
}
