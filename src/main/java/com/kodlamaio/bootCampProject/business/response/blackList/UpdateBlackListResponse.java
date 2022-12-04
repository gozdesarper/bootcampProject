package com.kodlamaio.bootCampProject.business.response.blackList;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBlackListResponse {
	private int id;
	private int applicantId;
	private LocalDate date;
	private String reason;

}
