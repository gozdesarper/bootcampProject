package com.kodlamaio.bootCampProject.business.response.bootcamp;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetBootcampResponse {
	private int id;
	private int instructorId;
	private String name;
	private LocalDate dateStart;
	private LocalDate dateEnd;
	private int state;

}
