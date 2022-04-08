package com.vti.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.vti.entity.Department;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DateDto {

	@DateTimeFormat(pattern = "yyy-MM-dd")
	private Date createdDate;
	
	@DateTimeFormat(pattern = "yyy-MM-dd")
	private Date minCreated_date;
	
	@DateTimeFormat(pattern = "yyy-MM-dd")
	private Date maxCreated_date;
	
	private Integer minYear;
	
	private Department.Type type;
	
}
