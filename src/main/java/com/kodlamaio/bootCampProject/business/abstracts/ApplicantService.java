package com.kodlamaio.bootCampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.bootCampProject.business.request.applicant.CreateApplicantRequest;
import com.kodlamaio.bootCampProject.business.request.applicant.UpdateApplicantRequest;
import com.kodlamaio.bootCampProject.business.response.applicant.CreatApplicantResponse;
import com.kodlamaio.bootCampProject.business.response.applicant.GetAllApplicantResponse;
import com.kodlamaio.bootCampProject.business.response.applicant.GetApplicantResponse;
import com.kodlamaio.bootCampProject.business.response.applicant.UpdateApplicantResponse;
import com.kodlamaio.bootCampProject.core.ultities.result.DataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.Result;
import com.kodlamaio.bootCampProject.entities.users.Applicant;



public interface ApplicantService {
		
	DataResult<CreatApplicantResponse> add(CreateApplicantRequest createAplicantRequest);
	DataResult<List<GetAllApplicantResponse>> getAll();
	Result delete(int id);
	DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateAplicantRequest);
	DataResult<GetApplicantResponse> getById(int id);
	Applicant getByApplicantId(int applicantId);
	
}
