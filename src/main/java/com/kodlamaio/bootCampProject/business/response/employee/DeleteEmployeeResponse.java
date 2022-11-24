package com.kodlamaio.bootCampProject.business.response.employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteEmployeeResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String position;

}
