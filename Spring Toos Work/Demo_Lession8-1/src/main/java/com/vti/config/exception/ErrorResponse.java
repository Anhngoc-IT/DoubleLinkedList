package com.vti.config.exception;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {

	@NotNull
	private String message;
	
	@NotNull
	private String detailMessage;
	
	@NotNull
	private Object error;
	
	@NotNull
	private Integer code;
	
	@NotNull
	private String moreInformation;
}
