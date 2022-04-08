package com.vti.dto;

import org.springframework.hateoas.RepresentationModel;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountsDto extends RepresentationModel<DepartmentDto>{

//	private Integer id;
	
	private String username;
	
	private String departmentName;


	
	
}
