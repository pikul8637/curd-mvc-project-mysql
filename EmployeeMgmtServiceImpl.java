package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepository;

@Service
public class EmployeeMgmtServiceImpl implements IEmployeeMgmtService{
@Autowired
private IEmployeeRepository empRepo;

	@Override
	public Iterable<Employee> showAllEmployees() {
		// TODO Auto-generated method stub
		return empRepo.findAll();
	}

}
