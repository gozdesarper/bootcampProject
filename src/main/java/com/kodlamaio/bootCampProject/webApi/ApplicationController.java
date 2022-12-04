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

import com.kodlamaio.bootCampProject.business.abstracts.ApplicationService;
import com.kodlamaio.bootCampProject.business.request.Application.CreateApplicationRequest;
import com.kodlamaio.bootCampProject.business.request.Application.UpdateApplicationRequest;
import com.kodlamaio.bootCampProject.business.response.Application.CreateApplicationResponse;
import com.kodlamaio.bootCampProject.business.response.Application.GetAllApplicationResponse;
import com.kodlamaio.bootCampProject.business.response.Application.GetApplicationResponse;
import com.kodlamaio.bootCampProject.business.response.Application.UpdateApplicationResponse;
import com.kodlamaio.bootCampProject.core.ultities.result.DataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.Result;

import lombok.AllArgsConstructor;
@AllArgsConstructor
@RestController
@RequestMapping("/api/applications")
public class ApplicationController {
	private ApplicationService applicationService;
	
	@PostMapping("")
	public DataResult<CreateApplicationResponse> add(@RequestBody CreateApplicationRequest creatApplicationRequest) {
		return this.applicationService.add(creatApplicationRequest);
	}
	@PutMapping("")
	public DataResult<UpdateApplicationResponse> update(@RequestBody UpdateApplicationRequest updateApplicationRequest) {
		return this.applicationService.update(updateApplicationRequest);
	}
	@DeleteMapping("/{id}")
	public Result delete(@PathVariable int id) {
		return this.applicationService.delete(id);
	}
	@GetMapping("/{id}")
	public DataResult<GetApplicationResponse> getById(@PathVariable int id) {
		return this.applicationService.getById(id);
	}
	@GetMapping("/getall")
	public DataResult<List<GetAllApplicationResponse>> getAll() {
		return this.applicationService.getAll();
	}
	
	}


