package com.kodlamaio.bootCampProject.business.concrete;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootCampProject.business.abstracts.ApplicantService;
import com.kodlamaio.bootCampProject.business.abstracts.ApplicationService;
import com.kodlamaio.bootCampProject.business.abstracts.BlackListService;
import com.kodlamaio.bootCampProject.business.abstracts.BootcampService;
import com.kodlamaio.bootCampProject.business.constants.Messages;
import com.kodlamaio.bootCampProject.business.request.Application.CreateApplicationRequest;
import com.kodlamaio.bootCampProject.business.request.Application.UpdateApplicationRequest;
import com.kodlamaio.bootCampProject.business.response.Application.CreateApplicationResponse;
import com.kodlamaio.bootCampProject.business.response.Application.GetAllApplicationResponse;
import com.kodlamaio.bootCampProject.business.response.Application.GetApplicationResponse;
import com.kodlamaio.bootCampProject.business.response.Application.UpdateApplicationResponse;
import com.kodlamaio.bootCampProject.core.ultities.exception.BusinessException;
import com.kodlamaio.bootCampProject.core.ultities.mapping.ModelMapperService;
import com.kodlamaio.bootCampProject.core.ultities.result.DataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.Result;
import com.kodlamaio.bootCampProject.core.ultities.result.SuccessDataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.SuccessResult;
import com.kodlamaio.bootCampProject.dataAccess.abstracts.ApplicationRepository;
import com.kodlamaio.bootCampProject.entities.Application;
import com.kodlamaio.bootCampProject.entities.Bootcamp;
import com.kodlamaio.bootCampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ApplicationManager implements ApplicationService {
	private ModelMapperService modelMapperService;
	private ApplicationRepository applicationRepository;
	private BootcampService bootcampService;
	private ApplicantService applicantService;
	private BlackListService blackListService;

	@Override
	public DataResult<CreateApplicationResponse> add(CreateApplicationRequest creatApplicationRequest) {
		checkIfApplicationExistByApplicantId(creatApplicationRequest.getApplicantId());
		checkIfApplicationExistByBootcampId(creatApplicationRequest.getBootcampId());
		bootcampService.checkIfApplicationExistState(creatApplicationRequest.getBootcampId());
		Application aplication = this.modelMapperService.forRequest().map(creatApplicationRequest, Application.class);
		applicationRepository.save(aplication);
		
		CreateApplicationResponse createApplicationResponse = this.modelMapperService.forResponse().map(aplication,
				CreateApplicationResponse.class);
		return new SuccessDataResult<CreateApplicationResponse>(createApplicationResponse, Messages.ApplicationCreated);
	}

	@Override
	public DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateApplicationRequest) {
		Application aplication = this.modelMapperService.forRequest().map(updateApplicationRequest, Application.class);
		applicationRepository.save(aplication);
		UpdateApplicationResponse createApplicationResponse = this.modelMapperService.forResponse().map(aplication,
				UpdateApplicationResponse.class);
		return new SuccessDataResult<UpdateApplicationResponse>(createApplicationResponse, Messages.ApplicationUpdated);
	}

	@Override
	public Result delete(int id) {
		checkIfApplicantExistById(id);
		this.applicationRepository.deleteById(id);
		return new SuccessResult(Messages.ApplicationDeleted);
	}

	@Override
	public DataResult<GetApplicationResponse> getById(int id) {
		checkIfApplicantExistById(id);
		Application aplication = this.applicationRepository.findById(id);
		GetApplicationResponse getApplicationResponse = this.modelMapperService.forResponse().map(aplication,
				GetApplicationResponse.class);
		return new SuccessDataResult<GetApplicationResponse>(getApplicationResponse, Messages.ApplicationGetted);
	}

	@Override
	public DataResult<List<GetAllApplicationResponse>> getAll() {
		List<Application> applications = this.applicationRepository.findAll();
		List<GetAllApplicationResponse> getAllApplicationResponses = applications.stream().map(
				application -> this.modelMapperService.forResponse().map(application, GetAllApplicationResponse.class))
				.collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllApplicationResponse>>(getAllApplicationResponses,
				Messages.ApplicationListed);
	}

	private void checkIfApplicantExistById(int id) {
		Application application = this.applicationRepository.findById(id);
	if(application==null){
			throw new BusinessException(Messages.ApplicationUserNotfond);		
		}
	
	}
	public void checkIfApplicationExistByBootcampId(int bootcampId) {
		Bootcamp bootcamp = this.bootcampService.getByBootcampId(bootcampId);
		if(bootcamp==null){
			throw new BusinessException(Messages.BootcampIdNotLogged);
		}
	}
	public void checkIfApplicationExistByApplicantId(int applicantId) {
		Applicant applicant = this.applicantService.getByApplicantId(applicantId);
		if(applicant==null) {
			throw new BusinessException(Messages.ApplicantUserNotfond);
		}
		}	
	public void checkIfApplicationExistByApplicant(int applicantId) {
		this.blackListService.checkApplicantId(applicantId);
	}
	

}
