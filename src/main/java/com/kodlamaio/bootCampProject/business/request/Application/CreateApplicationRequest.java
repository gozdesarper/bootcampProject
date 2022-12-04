package com.kodlamaio.bootCampProject.business.request.Application;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CreateApplicationRequest {
	@NotBlank
	private int applicantId;
	@NotBlank
	private int bootcampId;
	@NotBlank
	@Min(value = 1 ,message = "application open") 
	@Max(value = 2,message = "application closed")
	private int state;

}
