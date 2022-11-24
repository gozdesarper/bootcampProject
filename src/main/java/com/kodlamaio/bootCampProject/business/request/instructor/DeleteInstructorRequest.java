package com.kodlamaio.bootCampProject.business.request.instructor;

import com.kodlamaio.bootCampProject.business.response.employee.DeleteEmployeeResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteInstructorRequest {
	
	private int id;

}
