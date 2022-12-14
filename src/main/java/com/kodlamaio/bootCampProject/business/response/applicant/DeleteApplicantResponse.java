package com.kodlamaio.bootCampProject.business.response.applicant;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteApplicantResponse {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String about;
	private String nationalIdentity;
	private LocalDate dateOfBirth;
}
