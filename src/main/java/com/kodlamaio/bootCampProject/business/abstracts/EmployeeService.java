package com.kodlamaio.bootCampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.bootCampProject.business.request.employee.CreateEmployeeRequest;
import com.kodlamaio.bootCampProject.business.request.employee.UpdateEmployeeRequest;
import com.kodlamaio.bootCampProject.business.response.employee.CreatEmployeeResponse;
import com.kodlamaio.bootCampProject.business.response.employee.GetAllEmployeeResponse;
import com.kodlamaio.bootCampProject.business.response.employee.GetEmployeeResponse;
import com.kodlamaio.bootCampProject.business.response.employee.UpdateEmployeeResponse;
import com.kodlamaio.bootCampProject.core.ultities.result.DataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.Result;

public interface EmployeeService {
	
	DataResult<CreatEmployeeResponse> add(CreateEmployeeRequest createEmployeeRequest);
	DataResult<List<GetAllEmployeeResponse>> getAll();
	DataResult<UpdateEmployeeResponse>  update(UpdateEmployeeRequest updateEmployeeRequest);
	Result delete(int id);
	DataResult<GetEmployeeResponse> getById(int id);
	
}
