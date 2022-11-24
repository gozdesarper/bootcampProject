package com.kodlamaio.bootCampProject.webApi;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kodlamaio.bootCampProject.business.abstracts.EmployeeService;
import com.kodlamaio.bootCampProject.business.request.employee.CreateEmployeeRequest;
import com.kodlamaio.bootCampProject.business.request.employee.UpdateEmployeeRequest;
import com.kodlamaio.bootCampProject.business.response.employee.CreatEmployeeResponse;
import com.kodlamaio.bootCampProject.business.response.employee.GetAllEmployeeResponse;
import com.kodlamaio.bootCampProject.business.response.employee.GetEmployeeResponse;
import com.kodlamaio.bootCampProject.business.response.employee.UpdateEmployeeResponse;
import com.kodlamaio.bootCampProject.core.ultities.result.DataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.Result;

import lombok.AllArgsConstructor;
@RestController
@RequestMapping("/api/employee")
@AllArgsConstructor
public class EmployeeController {
	private EmployeeService employeeService;
	@PostMapping("/add")
	public DataResult<CreatEmployeeResponse> add(@RequestBody CreateEmployeeRequest createEmployeeRequest) {
		return employeeService.add(createEmployeeRequest);
	}
	@GetMapping("/getall")
	public DataResult<List<GetAllEmployeeResponse>> getAll() {
		return employeeService.getAll();
	}
	@PutMapping()
	public DataResult<UpdateEmployeeResponse> update(@RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
		return employeeService.update(updateEmployeeRequest);
	}
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return employeeService.delete(id);
	}
	@GetMapping("/getbyid")
	public DataResult<GetEmployeeResponse> getById(int id) {
		return employeeService.getById(id);
	}
	

}
