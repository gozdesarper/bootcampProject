package com.kodlamaio.bootCampProject.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.kodlamaio.bootCampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "blackList")
@AllArgsConstructor
@NoArgsConstructor

public class BlackList {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@ManyToOne()//applicant daki blacklist ile eşliyoruz.
	@JoinColumn(name="applicantId")
	private Applicant applicant;
	@Column(name = "date")
	private LocalDate date;
	@Column(name = "reason")
	private String reason;
	

}
