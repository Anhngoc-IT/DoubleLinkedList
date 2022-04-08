package com.vti.form;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DepartmentForm {

	private String name;
	
	private int totalMember;
	
	private String type;
}
