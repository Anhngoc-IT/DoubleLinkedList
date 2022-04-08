package com.vti.form;

public class DepartmentFilterForm {

	private Integer MinId;
	
	public Integer getMinId() {
		return MinId;
	}

	public void setMinId(Integer minId) {
		MinId = minId;
	}

	public Integer getMaxId() {
		return MaxId;
	}

	public void setMaxId(Integer maxId) {
		MaxId = maxId;
	}

	private Integer MaxId;

	public DepartmentFilterForm(Integer minId, Integer maxId) {
		super();
		MinId = minId;
		MaxId = maxId;
	}

	
	
	
	
}
