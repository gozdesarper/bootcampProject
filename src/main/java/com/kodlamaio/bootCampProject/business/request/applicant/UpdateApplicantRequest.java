package com.kodlamaio.bootCampProject.business.request.applicant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateApplicantRequest {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String about;


}
