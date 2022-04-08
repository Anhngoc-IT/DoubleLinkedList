package com.vti.form;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vti.entity.Account;
import com.vti.validate.DepartmentNameNotExists;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateDepartmentForm {

	@NotBlank(message = "{Department.createDepartment.form.name.NotBlank}")
	@Length(max = 50, message = "{Department.createDepartment.form.name.Length}")
	@JsonFormat(pattern = "Department_name")
	@DepartmentNameNotExists(message = "{Department.createDepartment.form.name.NotExists}")
	private String name;
	
	@PositiveOrZero(message = "The total member must be greater than or equal 0")
	private int totalMember;
	
	@Pattern(regexp = "DEV|TEST|PM", message = "the type must be DEV|TEST|PM")
	private String type;
	
	@NotEmpty(message = "Accounts mustn't be value empty")
	private List<Account> accounts;
	
	@Data
	@NoArgsConstructor
	public static class Account{
		
		@JsonFormat(pattern = "Account_username")
		private String username;
	}
}
