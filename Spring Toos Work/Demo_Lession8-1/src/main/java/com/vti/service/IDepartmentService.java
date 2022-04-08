package com.vti.service;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.dto.DateDto;
import com.vti.entity.Department;
import com.vti.form.AccountForm;
import com.vti.form.CreateDepartmentForm;
import com.vti.form.DepartmentForm;
import com.vti.form.UpdateDepartmentForm;

public interface IDepartmentService {

	public Page<Department> getAllDepartments(Pageable pageable, String search, DateDto date_o);

	public Department getDepartmentByID(int id);
	
	//public void createDepartment (DepartmentForm form);
	
	public void creteDepartment(CreateDepartmentForm form);
	
	public void updateDepartment (UpdateDepartmentForm updateForm);

	public boolean isDepartmentExistsByName(String name);

	public boolean isDepartmentExistsById(Integer id);
}
