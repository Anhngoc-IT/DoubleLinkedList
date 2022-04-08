package com.vti.specification;

import java.util.Date;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import com.vti.dto.DateDto;
import com.vti.entity.Department;

public class DepartmentSpecification {

	@SuppressWarnings({ "deprecation", "unused" })
	public static Specification<Department> builWhere(String search, DateDto date_o) {

		Specification<Department> where = null;

		if (!StringUtils.isEmpty(search)) {
			search = search.trim();

			CustomSpecificationDepartment username = new CustomSpecificationDepartment("username", search); // new CustomSpecificationDepartment("username", search);

			return where = Specification.where(username);

		}

		if (date_o != null && date_o.getCreatedDate() != null) {
			CustomSpecificationDepartment created_date = new CustomSpecificationDepartment("createdDate",
					date_o.getCreatedDate());

			if (where == null) {
				where = Specification.where(created_date);
			} else {
				where = where.and(created_date);
			}
		}

		if (date_o != null && date_o.getMaxCreated_date() != null) {
			CustomSpecificationDepartment maxCreated_date = new CustomSpecificationDepartment("maxCreated_date",
					date_o.getMaxCreated_date());

			if (where == null) {
				where = Specification.where(maxCreated_date);
			} else {
				where = where.and(maxCreated_date);
			}
		}

		if (date_o != null && date_o.getMinCreated_date() != null) {
			CustomSpecificationDepartment minCreated_date = new CustomSpecificationDepartment("minCreated_date",
					date_o.getMinCreated_date());

			if (where == null) {
				where = Specification.where(minCreated_date);
			} else {
				where = where.and(minCreated_date);
			}
		}

		if (date_o != null && date_o.getMinYear() != null) {
			CustomSpecificationDepartment minYear = new CustomSpecificationDepartment("minYear", date_o.getMinYear());

			if (where == null) {
				where = Specification.where(minYear);
			} else {
				where = where.and(minYear);
			}
		}
		
		if (date_o != null && date_o.getType() != null) {
			CustomSpecificationDepartment type = new CustomSpecificationDepartment("type", date_o.getType());
			
			if(where == null) {
				where = Specification.where(type);
			}else {
				where = where.and(type);
			}
		}
		return where;

	}
}

	@SuppressWarnings("serial")
	class CustomSpecificationDepartment implements Specification<Department> {

		private String filed;

		private Object value;

		public CustomSpecificationDepartment(String filed, Object value) {
			super();
			this.filed = filed;
			this.value = value;
		}

		@SuppressWarnings("unchecked")
		@Override
		public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

			if (filed.equalsIgnoreCase("username")) {

				@SuppressWarnings("rawtypes")
				Join join = root.join("accounts", JoinType.LEFT);
				return criteriaBuilder.like(join.get("username"), "%" + value.toString() + "%");
			}

			if (filed.equalsIgnoreCase("createdDate")) {
				return criteriaBuilder.equal(root.get("createdDate").as(java.sql.Date.class), (Date) value);
			}

			if (filed.equalsIgnoreCase("minYear")) {
				return criteriaBuilder.greaterThanOrEqualTo(
						criteriaBuilder.function("YEAR", Integer.class, root.get("createdDate")),
						(Integer) value);
			}

			if (filed.equalsIgnoreCase("minCreated_date")) {
				return criteriaBuilder.greaterThanOrEqualTo(root.get("createdDate").as(java.sql.Date.class),
						(Date) value);
			}

			if (filed.equalsIgnoreCase("maxCreated_date")) {
				return criteriaBuilder.lessThanOrEqualTo(root.get("createdDate").as(java.sql.Date.class), (Date) value);
			}
			
			if(filed.equalsIgnoreCase("type")) {
				return criteriaBuilder.equal(root.get("type"), value);
			}
			return null;
		}
	}
