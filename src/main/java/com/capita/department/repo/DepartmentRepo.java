package com.capita.department.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capita.department.entity.Department;


@Repository
public interface DepartmentRepo  extends  JpaRepository<Department,Long>{

	
	Department findByDepartmentId(long departmentId);

	
	
}
