package com.vti.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.vti.entity.Account;
import com.vti.form.DepartmentFilterForm;

public class AccountSpecification {

	@SuppressWarnings({ "deprecation", "unused" })
	public static Specification<Account> buildWhere(String search, DepartmentFilterForm form) {
		Specification<Account> where = null;
		
		// Search
		if(!StringUtils.isEmpty(search)) {	
		search = search.trim();
		
		// value mà mk muốn search là search
		// username là filed
		// build 1 condition WHERE username LIKE "%abc%"
		CustomSpecification name = new CustomSpecification("username", search);
		CustomSpecification departmentname = new CustomSpecification("departmentName", search);
		
		//đính kèm câu lệnh where vào
		return Specification.where(name).or(departmentname);
		}
		
		// Having filter by minId
		if(form != null && form.getMinId() != null) {
			CustomSpecification minId = new CustomSpecification("MinId", form.getMinId());
			
			if(where == null) {
				where = minId;
			} else {
				where = where.and(minId);
			}
		}
		
		// Having filter by MaxId
		if(form != null && form.getMaxId() != null) {
			CustomSpecification maxId = new CustomSpecification("MaxId", form.getMaxId());
			
			if(where == null) {
				where = maxId;
			}else {
				where = where.and(maxId);
			}
		}
		return where;
	}

	
}

@SuppressWarnings("serial")
class CustomSpecification implements Specification<Account>{

	private String field;
	
	private Object value;
	
	
	public CustomSpecification(String field, Object value) {
		
		this.field = field;
		this.value = value;
	}


	@Override
	public Predicate toPredicate(
			                     Root<Account> root,
			                     CriteriaQuery<?> query, 
			                     CriteriaBuilder criteriaBuilder) {
		
		if(field.equalsIgnoreCase("username")) {
			return criteriaBuilder.like(root.get("username"), "%" + value.toString()+ "%");
		}
		
		if(field.equalsIgnoreCase("departmentName")) {
			return criteriaBuilder.like(root.get("department").get("name"), "%" + value.toString()+ "%");
		}
		
		if(field.equalsIgnoreCase("MaxId")) {
			return criteriaBuilder.lessThanOrEqualTo(root.get("id"), value.toString());
		}
		
		if(field.equalsIgnoreCase("MinId")) {
			return criteriaBuilder.greaterThanOrEqualTo(root.get("id"), value.toString());
		}
		return null;
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
