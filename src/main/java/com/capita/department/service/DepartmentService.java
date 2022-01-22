package com.capita.department.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capita.department.entity.Department;
import com.capita.department.repo.DepartmentRepo;

@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;
	
	
	public Department saveDepartment(Department department) {
		
		Department departmentObj = departmentRepo.save(department);
		
		return departmentObj;
	}


	public Department getDepartmentById(long departmentId) {
		Department departmentObj =departmentRepo.findByDepartmentId(departmentId);
		return departmentObj;
	}


	public List<Department> getDepartments() {
		List<Department> departments = departmentRepo.findAll();
		return departments;
	}

}
