package com.kodlamaio.bootCampProject.entities.users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.kodlamaio.bootCampProject.entities.Application;
import com.kodlamaio.bootCampProject.entities.BlackList;

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
	@OneToMany(mappedBy = "applicant")
	private List<BlackList> blackList;
	@OneToMany(mappedBy = "applicant")
	private List<Application> applications;
	
}
