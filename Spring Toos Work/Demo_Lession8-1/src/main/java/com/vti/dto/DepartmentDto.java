package com.vti.dto;

import java.util.Date;
import java.util.List;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.vti.entity.Account;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentDto extends RepresentationModel<DepartmentDto>{

	private Integer id;
	
	@JsonProperty("department_name")
	private String name;
	
	private int totalMember;
	
	private String type;
	
	@JsonFormat(pattern = "yyy-MM-dd")
	private Date createdDate;
	
	private List<AccountDto> accounts;
	

	@Data
	@NoArgsConstructor
	public static class AccountDto extends RepresentationModel<DepartmentDto>{
		
		private int id;
		
		private String username;
	}

		
}
