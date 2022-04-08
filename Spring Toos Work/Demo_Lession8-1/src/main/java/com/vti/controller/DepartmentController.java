package com.vti.controller;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Locale;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vti.dto.DateDto;
import com.vti.dto.DepartmentDto;
import com.vti.entity.Department;
import com.vti.form.CreateDepartmentForm;
import com.vti.form.DepartmentForm;
import com.vti.form.UpdateDepartmentForm;
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
@Validated
public class DepartmentController {

	@Autowired
	private ModelMapper ModelMapper;
	
	@Autowired
	private MessageSource messageSource;
	
	@Autowired
	private IDepartmentService service;
	

	@SuppressWarnings("rawtypes")
	@GetMapping()
	public Page<DepartmentDto> getAllDepartments(
			                                    Pageable pageable, 	
			                                    DateDto date_o,
			                                    @RequestParam(value = "search", 
			                                    required = false) String search){
		
		Page<Department> entityPage = service.getAllDepartments(pageable, search, date_o);
		
		// convert--> dto
		
		List<DepartmentDto> dtos = ModelMapper.map(entityPage.getContent(), new TypeToken<List<DepartmentDto>>() {}.getType());
		
		// add HATEOAS
//		for (DepartmentDto dto : dtos) {
//			for(DepartmentDto.AccountDto accountDto : dto.getAccounts()) {
//				accountDto.add(linkTo(methodOn(AccountController.class).getAccountById(accountDto.getId())).withSelfRel());
//			}
//			dto.add(linkTo(methodOn(DepartmentController.class).getDepartmentByID(dto.getId())).withSelfRel());
//		}
		@SuppressWarnings("unchecked")
		Page<DepartmentDto> dtoPages = new PageImpl(dtos, pageable, entityPage.getTotalElements());
		
		return dtoPages;		
	}

	@GetMapping(value = "/{id}")
	public DepartmentDto getDepartmentByID(@PathVariable(name = "id") int id){
//		                return messageSource.getMessage(key, null, "Default message", Locale.US);
		Department entity = service.getDepartmentByID(id);

		// convert entity to dto
		DepartmentDto dto = ModelMapper.map(entity, DepartmentDto.class);
		
//		dto.add(linkTo(methodOn(DepartmentController.class).getDepartmentByID(id)).withSelfRel());

		return dto;
	}
	
	
	@PutMapping(value = "/{id}")
	public void updateDepartment (@PathVariable (name = "id") int id, @RequestBody UpdateDepartmentForm updateForm) {
		
		updateForm.setId(id);
		
		service.updateDepartment(updateForm);
	}
	
	@PostMapping
	public void createDepartment( @Valid @RequestBody CreateDepartmentForm form) {
		service.creteDepartment(form);
	}
	
	@GetMapping(value = "/exception")
	public void testException() throws Exception{
		// orther logic
		throw new EntityNotFoundException("... Exception Information");
		// orther code
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
