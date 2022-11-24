package com.kodlamaio.bootCampProject.entities.users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "aplicants")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Applicant extends User {

	
	@Column(name = "about")
	private String about;


}
