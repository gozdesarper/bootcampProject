package com.kodlamaio.bootCampProject.business.request.Application;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateApplicationRequest {
	@NotBlank
	private int userId;
	@NotBlank
	private int bootcampId;
	@NotBlank
	private int state;

}
