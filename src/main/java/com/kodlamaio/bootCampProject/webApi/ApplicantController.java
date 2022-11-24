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

import com.kodlamaio.bootCampProject.business.abstracts.ApplicantService;
import com.kodlamaio.bootCampProject.business.request.applicant.CreateApplicantRequest;
import com.kodlamaio.bootCampProject.business.request.applicant.DeleteApplicantRequest;
import com.kodlamaio.bootCampProject.business.request.applicant.UpdateApplicantRequest;
import com.kodlamaio.bootCampProject.business.response.applicant.CreatApplicantResponse;
import com.kodlamaio.bootCampProject.business.response.applicant.DeleteApplicantResponse;
import com.kodlamaio.bootCampProject.business.response.applicant.GetAllApplicantResponse;
import com.kodlamaio.bootCampProject.business.response.applicant.GetApplicantResponse;
import com.kodlamaio.bootCampProject.business.response.applicant.UpdateApplicantResponse;
import com.kodlamaio.bootCampProject.core.ultities.result.DataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.Result;

import lombok.AllArgsConstructor;
@RestController
@AllArgsConstructor
@RequestMapping("/api/applicants")
public class ApplicantController {
	private ApplicantService applicantService;
	
	@PostMapping("/add")
	public DataResult<CreatApplicantResponse> add(@RequestBody CreateApplicantRequest createApplicantRequest) {
		return applicantService.add(createApplicantRequest);
	}
	@GetMapping("/getall")
	public DataResult<List<GetAllApplicantResponse>> getAll() {
		return applicantService.getAll();
	}
	@DeleteMapping("/{id}")
	public Result delete(int id) {
		return applicantService.delete(id);
	}
	@PutMapping()
	public DataResult<UpdateApplicantResponse> update(@RequestBody UpdateApplicantRequest updateApplicantRequest) {
		return applicantService.update(updateApplicantRequest);
	}
	@GetMapping("/{id}")
	public DataResult<GetApplicantResponse> getById(@PathVariable int id) {
		return applicantService.getById(id);
	}
}
