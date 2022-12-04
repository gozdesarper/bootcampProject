package com.kodlamaio.bootCampProject.business.request.instructor;


import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInstructorRequest {
	
	@NotNull
	private int id;
	@NotBlank(message = "please enter your name")
	private String firstName;
	@NotBlank
	private String lastName;
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dateOfBirth;
	@Email
	private String email;
	@Size(min = 10, max = 15)
	private String password;
	@NotBlank
	private String companyName;
	@Size(min = 11, max = 11)
	private String nationalIdentity;

}
