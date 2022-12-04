package com.kodlamaio.bootCampProject.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.kodlamaio.bootCampProject.entities.users.Applicant;
import com.kodlamaio.bootCampProject.entities.users.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Applications")
@AllArgsConstructor
@NoArgsConstructor

public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "applicantId")
	private Applicant applicant;
	
	@ManyToOne
	@JoinColumn(name = "bootcampId")
	private Bootcamp bootcamp;
	
	@Column(name = "state")
	private int state;
	

}
