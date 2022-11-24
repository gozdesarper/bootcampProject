package com.kodlamaio.bootCampProject.business.request.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmployeeRequest {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String position;


}
