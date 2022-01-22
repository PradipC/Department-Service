package com.capita.department.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capita.department.controller.DepartmentController;
import com.capita.department.entity.Department;
import com.capita.department.repo.DepartmentRepo;

@Service
public class DepartmentService {

	
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentService.class);

	
	@Autowired
	private DepartmentRepo departmentRepo;
	
	
	public Department saveDepartment(Department department) {
		
		LOGGER.info("DepartmentService.saveDepartment()");
		
		Department departmentObj = departmentRepo.save(department);
		
		return departmentObj;
	}


	public Department getDepartmentById(long departmentId) {
		
		LOGGER.info("DepartmentService.getDepartmentById()");
		
		Department departmentObj =departmentRepo.findByDepartmentId(departmentId);
		return departmentObj;
	}


	public List<Department> getDepartments() {
		List<Department> departments = departmentRepo.findAll();
		return departments;
	}

}
