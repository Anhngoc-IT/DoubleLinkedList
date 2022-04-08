package com.vti.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vti.dto.DateDto;
import com.vti.entity.Account;
import com.vti.entity.Department;
import com.vti.form.AccountForm;
import com.vti.form.CreateDepartmentForm;
import com.vti.form.DepartmentForm;
import com.vti.form.UpdateDepartmentForm;
import com.vti.repository.IAccountRepository;
import com.vti.repository.IDepartmentRepository;
import com.vti.specification.DepartmentSpecification;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IAccountRepository accountRepository;

	@Override
	public Page<Department> getAllDepartments(Pageable pageable, String search, DateDto date_o) {
		
		Specification<Department> conditions = DepartmentSpecification.builWhere(search, date_o);
		
		return repository.findAll(conditions, pageable);
	}

	@Override
	public Department getDepartmentByID(int id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}


	@Override
	@Transactional
	public void updateDepartment(UpdateDepartmentForm updateForm) {
		
		Department department = modelMapper.map(updateForm, Department.class);
		
		repository.save(department);
		
	}

	@Override
	@Transactional
	public void creteDepartment(CreateDepartmentForm form) {
		
		// convert form to entity
		Department departmentEntiry = modelMapper.map(form, Department.class);
		
		// create department
		Department department = repository.save(departmentEntiry);
		
		// create accounts
		List<Account> accountEntity = departmentEntiry.getAccounts();
		
		for (Account account : accountEntity) {
			account.setDepartment(department);
		}
		
		accountRepository.saveAll(accountEntity);
		
		
	}

	@Override
	public boolean isDepartmentExistsByName(String name) {
		// TODO Auto-generated method stub
		return repository.existsByName(name);
	}

	@Override
	public boolean isDepartmentExistsById(Integer id) {
		// TODO Auto-generated method stub
		return repository.existsById(id);
	}

	
	
	
	
	
	
	
	
	
	
	
}
