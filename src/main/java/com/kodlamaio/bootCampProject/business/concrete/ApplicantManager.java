package com.kodlamaio.bootCampProject.business.concrete;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootCampProject.business.abstracts.ApplicantService;
import com.kodlamaio.bootCampProject.business.constants.Messages;
import com.kodlamaio.bootCampProject.business.request.applicant.CreateApplicantRequest;
import com.kodlamaio.bootCampProject.business.request.applicant.UpdateApplicantRequest;
import com.kodlamaio.bootCampProject.business.response.applicant.CreatApplicantResponse;
import com.kodlamaio.bootCampProject.business.response.applicant.GetAllApplicantResponse;
import com.kodlamaio.bootCampProject.business.response.applicant.GetApplicantResponse;
import com.kodlamaio.bootCampProject.business.response.applicant.UpdateApplicantResponse;
import com.kodlamaio.bootCampProject.core.ultities.mapping.ModelMapperService;
import com.kodlamaio.bootCampProject.core.ultities.result.DataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.Result;
import com.kodlamaio.bootCampProject.core.ultities.result.SuccessDataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.SuccessResult;
import com.kodlamaio.bootCampProject.dataAccess.abstracts.ApplicantRepository;
import com.kodlamaio.bootCampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ApplicantManager implements ApplicantService {

	private ApplicantRepository applicantRepository;
	private ModelMapperService modelMapperService;

	@Override
	public DataResult<CreatApplicantResponse> add(CreateApplicantRequest createAplicantRequest) {
		Applicant applicant = this.modelMapperService.forRequest().map(createAplicantRequest, Applicant.class);
		applicantRepository.save(applicant);
		CreatApplicantResponse creatApplicantResponse = this.modelMapperService.forResponse().map(applicant,
				CreatApplicantResponse.class);
		return new SuccessDataResult<CreatApplicantResponse>(creatApplicantResponse, Messages.ApplicantCreated);
	}

	@Override
	public DataResult<List<GetAllApplicantResponse>> getAll() {
		List<Applicant> applicants = this.applicantRepository.findAll();
		List<GetAllApplicantResponse> getAllApplicantResponses = applicants.stream()
				.map(applicant -> this.modelMapperService.forResponse().map(applicant, GetAllApplicantResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllApplicantResponse>>(getAllApplicantResponses, Messages.ApplicantListed);
	}

	@Override
	public Result delete(int id) {
		applicantRepository.deleteById(id);
		return new SuccessResult(Messages.ApplicantDeleted);
	}

	@Override
	public DataResult<UpdateApplicantResponse> update(UpdateApplicantRequest updateAplicantRequest) {
		Applicant applicant = this.modelMapperService.forRequest().map(updateAplicantRequest, Applicant.class);
		UpdateApplicantResponse updateApplicantResponse = this.modelMapperService.forResponse().map(applicant, UpdateApplicantResponse.class);
		return new SuccessDataResult<UpdateApplicantResponse>(updateApplicantResponse,Messages.ApplicantUpdated);
	}

	@Override
	public DataResult<GetApplicantResponse> getById(int id) {
		Applicant applicant = this.applicantRepository.findById(id).get();
		GetApplicantResponse getApplicantResponse = this.modelMapperService.forResponse().map(applicant, GetApplicantResponse.class);
		return new SuccessDataResult<GetApplicantResponse>(getApplicantResponse,Messages.ApplicantGetted);
	}
}