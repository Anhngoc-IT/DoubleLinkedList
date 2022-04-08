package com.vti.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.vti.entity.Account;
import com.vti.form.CreateAccountForm;
import com.vti.form.DepartmentFilterForm;
import com.vti.repository.IAccountRepository;
import com.vti.specification.AccountSpecification;

@Service
public class AccountService implements IAccountService {

	@Autowired
	private IAccountRepository repository;
	
	@Autowired
	private ModelMapper modelMapper;
//
//	public List<Account> getAllAccounts() {
//		return repository.findAll();
//	}
//
//	public Account getAccountByID(int id) {
//		return repository.findById(id).get();
//	}

	@Override
	public Page<Account> getAllAccount(Pageable pageable, String search, DepartmentFilterForm form) {
		
		// tách riêng accSpe để xử lý condition Where
		Specification<Account> condition = AccountSpecification.buildWhere(search, form);
		

		return repository.findAll(condition, pageable);
	}

	@Override
	public void createAccount(CreateAccountForm createForm) {
		
		// omit id filed
		TypeMap<CreateAccountForm, Account> typeMap = modelMapper.getTypeMap(CreateAccountForm.class, Account.class);
		
		if(typeMap == null) {//if not already added
			// skip field
			modelMapper.addMappings(new PropertyMap<CreateAccountForm, Account>(){

				@Override
				protected void configure() {
					// destination là cái thằng Account
					// cấm convert account id
					skip(destination.getId());
					
				}
				
			});
		}
		
		Account account = modelMapper.map(createForm, Account.class);
		
		repository.save(account);
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
