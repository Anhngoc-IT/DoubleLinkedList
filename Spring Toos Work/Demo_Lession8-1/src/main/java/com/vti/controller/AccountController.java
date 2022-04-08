package com.vti.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.config.ComponentConfiguration;
import com.vti.dto.AccountsDto;
import com.vti.entity.Account;
import com.vti.form.CreateAccountForm;
import com.vti.form.DepartmentFilterForm;
import com.vti.service.IAccountService;

@RestController
@RequestMapping(value = "api/v1/accounts")
public class AccountController {

	@Autowired
	private ModelMapper ModelMapper;
	
	@Autowired
	private IAccountService service;
//
//	@GetMapping()
//	public List<AccountsDto> getAllAccounts() {
//		List<Account> entities = service.getAllAccounts();
//		
//		//convert to dtos
//		List<AccountsDto> dtos = ModelMapper.map(entities, new TypeToken<List<AccountsDto>>() {
//		}.getType());
//		
//		return dtos;
//
//	}
//
//	@GetMapping(value = "/{id}")
//	public AccountsDto getAccountByID(@PathVariable(name = "id") int id) {
//		Account entity = service.getAccountByID(id);
//
//		// convert entity to dto
//		//AccountsDTO dto = ModelMapper.map(entity, AccountsDTO.class);
//		
//		AccountsDto dto = ModelMapper.map(entity, AccountsDto.class);
//
//		return dto;
//	}

	@SuppressWarnings("rawtypes")
	@GetMapping()
	Page<AccountsDto> getAllAccounts(
			                  Pageable pageable,
			                  DepartmentFilterForm form,
			                  @RequestParam(value = "search", required = false) String search){
		
		Page<Account> entiPage = service.getAllAccount(pageable, search, form);
		
		// convert entity --> dto
		
		List<AccountsDto> dtos = ModelMapper.map(entiPage.getContent(), new TypeToken<List<AccountsDto>>() {}.getType());
		
		@SuppressWarnings("unchecked")
		Page<AccountsDto> dtoPages = new PageImpl(dtos, pageable, entiPage.getTotalElements());
		
		return dtoPages;
	}
	
	@PostMapping()
	public void createAccount (@RequestBody CreateAccountForm form) {
		
		service.createAccount(form);
	}
	
	
	
	
}
