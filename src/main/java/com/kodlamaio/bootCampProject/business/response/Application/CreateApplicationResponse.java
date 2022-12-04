package com.kodlamaio.bootCampProject.business.response.Application;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateApplicationResponse {
	private int id;
	private int userId;
	private int bootcampId;
	private int state;

}
