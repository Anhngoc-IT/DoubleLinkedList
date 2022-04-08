package com.vti.service;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.vti.entity.Account;
import com.vti.form.CreateAccountForm;
import com.vti.form.DepartmentFilterForm;

public interface IAccountService {
//
//	public List<Account> getAllAccounts();
//
//	public Account getAccountByID(int id);
	
	public Page<Account> getAllAccount(Pageable pageable, String search, DepartmentFilterForm form);

	public void createAccount (CreateAccountForm createForm);
}
