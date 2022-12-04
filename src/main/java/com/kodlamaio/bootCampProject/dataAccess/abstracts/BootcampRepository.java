package com.kodlamaio.bootCampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootCampProject.entities.Bootcamp;

public interface BootcampRepository extends JpaRepository<Bootcamp, Integer>{
	
	Bootcamp findById (int id);
	
	

}
