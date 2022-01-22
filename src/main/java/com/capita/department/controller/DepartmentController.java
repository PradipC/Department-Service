package com.capita.department.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capita.department.entity.Department;
import com.capita.department.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	private DepartmentService departmentService;

	//this method for saving department
	@PostMapping("/")
	private ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
		Department departmentObj = departmentService.saveDepartment(department);
		LOGGER.info("saved departmentObj is : " + departmentObj);
		return new ResponseEntity<>(departmentObj, HttpStatus.OK);
	}

	
	//this method for getting department
	@GetMapping("/{id}")
	private ResponseEntity<Department> getDepartmentById(@PathVariable("id") long departmentId) {
		//calling service
		Department departmentObj = departmentService.getDepartmentById(departmentId);
		LOGGER.info("get departmentObj by id is : " + departmentObj);
		return new ResponseEntity<>(departmentObj, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	private ResponseEntity<Department> deleteDepartmentById(@PathVariable("id") long departmentId) {
		 departmentService.deleteDepartmentById(departmentId);
		 LOGGER.info("deleted department by id is : " + departmentId);
		 return new ResponseEntity<>( HttpStatus.OK);
	}

	
	
	
	
	//this method will return all list of departments 
	@GetMapping("/")
	private ResponseEntity<List<Department>> getDepartments() {
		List<Department> departments = departmentService.getDepartments();
		LOGGER.info("departments are : " + departments);
		return new ResponseEntity<List<Department>>(departments, HttpStatus.OK);
	}

}
