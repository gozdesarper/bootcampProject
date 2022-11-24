package com.kodlamaio.bootCampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootCampProject.entities.users.Applicant;

public interface ApplicantRepository extends JpaRepository<Applicant, Integer>{

}
