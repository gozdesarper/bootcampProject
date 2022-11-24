package com.kodlamaio.bootCampProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootCampProject.entities.users.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Integer>{

}
