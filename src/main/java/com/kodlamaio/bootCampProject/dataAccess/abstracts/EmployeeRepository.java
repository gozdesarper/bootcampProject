package com.kodlamaio.bootCampProject.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodlamaio.bootCampProject.entities.users.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{


	Employee findEmployeeByNationalIdentity(String nationalIdentity); 

}
