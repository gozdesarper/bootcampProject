package com.kodlamaio.bootCampProject.business.response.employee;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllEmployeeResponse {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String nationalIdentity;
	private LocalDate dateOfBirth;
	private String position;
}
