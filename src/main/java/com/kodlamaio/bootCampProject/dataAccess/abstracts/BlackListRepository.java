package com.kodlamaio.bootCampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootCampProject.entities.BlackList;

public interface BlackListRepository extends JpaRepository<BlackList, Integer>{
	
	BlackList findById (int id);
	BlackList findByApplicantId(int applicantId);

}
