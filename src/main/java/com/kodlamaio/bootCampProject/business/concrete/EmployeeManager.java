package com.kodlamaio.bootCampProject.business.concrete;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.kodlamaio.bootCampProject.business.abstracts.EmployeeService;
import com.kodlamaio.bootCampProject.business.constants.Messages;
import com.kodlamaio.bootCampProject.business.request.employee.CreateEmployeeRequest;
import com.kodlamaio.bootCampProject.business.request.employee.DeleteEmployeeRequest;
import com.kodlamaio.bootCampProject.business.request.employee.UpdateEmployeeRequest;
import com.kodlamaio.bootCampProject.business.response.employee.CreatEmployeeResponse;
import com.kodlamaio.bootCampProject.business.response.employee.DeleteEmployeeResponse;
import com.kodlamaio.bootCampProject.business.response.employee.GetAllEmployeeResponse;
import com.kodlamaio.bootCampProject.business.response.employee.GetEmployeeResponse;
import com.kodlamaio.bootCampProject.business.response.employee.UpdateEmployeeResponse;
import com.kodlamaio.bootCampProject.core.ultities.mapping.ModelMapperService;
import com.kodlamaio.bootCampProject.core.ultities.result.DataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.Result;
import com.kodlamaio.bootCampProject.core.ultities.result.SuccessDataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.SuccessResult;
import com.kodlamaio.bootCampProject.dataAccess.abstracts.EmployeeRepository;
import com.kodlamaio.bootCampProject.entities.users.Employee;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class EmployeeManager implements EmployeeService {
	private EmployeeRepository employeeRepository;
	private ModelMapperService modelMapperService;
	@Override
	public DataResult<CreatEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest) {
		Employee employee = this.modelMapperService.forRequest().map(createEmployeeRequest, Employee.class);
		employeeRepository.save(employee);
		CreatEmployeeResponse creatEmployeeResponse = this.modelMapperService.forResponse().map(employee, CreatEmployeeResponse.class);
		return new SuccessDataResult<CreatEmployeeResponse>(creatEmployeeResponse,Messages.EmployeeCreated);
	}

	@Override
	public DataResult<List<GetAllEmployeeResponse>> getAll() {
		List<GetAllEmployeeResponse> employeeResponses = new ArrayList<GetAllEmployeeResponse>();
		List<Employee> employees = this.employeeRepository.findAll();
		for (Employee employee : employees) {
			GetAllEmployeeResponse listEmployeeResponse = this.modelMapperService.forResponse().map(employee,GetAllEmployeeResponse.class);
			employeeResponses.add(listEmployeeResponse);
		}
		return new SuccessDataResult<List<GetAllEmployeeResponse>>(employeeResponses,Messages.EmployeeListed);
	}
	@Override
	public DataResult<UpdateEmployeeResponse> update(UpdateEmployeeRequest updateEmployeeRequest) {
	Employee employee = this.modelMapperService.forRequest().map(updateEmployeeRequest, Employee.class);
	employeeRepository.save(employee);
	UpdateEmployeeResponse updateEmployeeResponse = this.modelMapperService.forResponse().map(employee, UpdateEmployeeResponse.class);
		return new SuccessDataResult<UpdateEmployeeResponse>(updateEmployeeResponse,Messages.UpdateUpdated);
	}

	@Override
	public Result delete(int id) {
		 Employee employee = this.employeeRepository.findById(id).get();
		 employeeRepository.delete(employee);
		return new SuccessResult(Messages.EmployeeDeleted);
	}

	@Override
	public DataResult<GetEmployeeResponse> getById(int id) {
		Employee employee = this.employeeRepository.findById(id).get();
		GetEmployeeResponse getEmployeeResponse = this.modelMapperService.forResponse().map(employee, GetEmployeeResponse.class);
		return new SuccessDataResult<GetEmployeeResponse>(getEmployeeResponse);
	}

}
