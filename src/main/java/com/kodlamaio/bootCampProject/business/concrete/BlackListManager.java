package com.kodlamaio.bootCampProject.business.concrete;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootCampProject.business.abstracts.ApplicantService;
import com.kodlamaio.bootCampProject.business.abstracts.BlackListService;
import com.kodlamaio.bootCampProject.business.constants.Messages;
import com.kodlamaio.bootCampProject.business.request.blackList.CreatBlackListRequest;
import com.kodlamaio.bootCampProject.business.request.blackList.UpdateBlackListRequest;
import com.kodlamaio.bootCampProject.business.response.blackList.CreateBlackListResponse;
import com.kodlamaio.bootCampProject.business.response.blackList.GetAllBlackListResponse;
import com.kodlamaio.bootCampProject.business.response.blackList.GetBlackListResponse;
import com.kodlamaio.bootCampProject.business.response.blackList.UpdateBlackListResponse;
import com.kodlamaio.bootCampProject.core.ultities.exception.BusinessException;
import com.kodlamaio.bootCampProject.core.ultities.mapping.ModelMapperService;
import com.kodlamaio.bootCampProject.core.ultities.result.DataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.Result;
import com.kodlamaio.bootCampProject.core.ultities.result.SuccessDataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.SuccessResult;
import com.kodlamaio.bootCampProject.dataAccess.abstracts.BlackListRepository;
import com.kodlamaio.bootCampProject.entities.BlackList;
import com.kodlamaio.bootCampProject.entities.users.Applicant;

import lombok.AllArgsConstructor;
@Service
@AllArgsConstructor
public class BlackListManager implements BlackListService {
	private BlackListRepository  blackListRepository;
	private ModelMapperService modelMapperService;
	private ApplicantService applicantService;

	@Override
	public DataResult<CreateBlackListResponse> add(CreatBlackListRequest creatBlackListRequest) {
		checkIfBlackListExistByApplicantId(creatBlackListRequest.getApplicantId());
		checkIfBlackListExistByApplicant(creatBlackListRequest.getApplicantId());
		BlackList blackList = this.modelMapperService.forRequest().map(creatBlackListRequest, BlackList.class);
		blackListRepository.save(blackList);
		CreateBlackListResponse createBlackListResponse = this.modelMapperService.forResponse().map(blackList, CreateBlackListResponse.class);
		return new SuccessDataResult<CreateBlackListResponse>(createBlackListResponse,Messages.BlackListCreated);
	}
	@Override
	public DataResult<UpdateBlackListResponse> update(UpdateBlackListRequest updateBlackListRequest) {
		checkIfBlackListExistByApplicantId(updateBlackListRequest.getApplicantId());
		checkIfBlackListExistByApplicant(updateBlackListRequest.getApplicantId());
		checkIfBlackListId(updateBlackListRequest.getId());
		BlackList blackList = this.modelMapperService.forRequest().map(updateBlackListRequest, BlackList.class);
		blackListRepository.save(blackList);
		UpdateBlackListResponse updateBlackListResponse = this.modelMapperService.forResponse().map(blackList, UpdateBlackListResponse.class);
		return new SuccessDataResult<UpdateBlackListResponse>(updateBlackListResponse,Messages.BlackListCreated);
	}
	@Override
	public DataResult<GetBlackListResponse> getById(int id) {
		checkIfBlackListId(id);
		BlackList blackList = this.blackListRepository.findById(id);
		GetBlackListResponse getBlackListResponse = this.modelMapperService.forResponse().map(blackList, GetBlackListResponse.class);
		return new SuccessDataResult<GetBlackListResponse>(getBlackListResponse,Messages.BlackListGetById);
	}
	@Override
	public Result delete(int id) {
		checkIfBlackListId(id);
		this.blackListRepository.deleteAll();
		return new SuccessResult(Messages.UserListed);
	}
	@Override
	public DataResult<List<GetAllBlackListResponse>> getAll() {
		List<BlackList> blackLists = this.blackListRepository.findAll();
		List<GetAllBlackListResponse> getAllBlackListResponses = blackLists.stream()
				.map(blackList -> this.modelMapperService.forResponse().map(blackList, GetAllBlackListResponse.class)).collect(Collectors.toList());
		return new SuccessDataResult<List<GetAllBlackListResponse>>(getAllBlackListResponses,Messages.BlackListListed);
	}
	private void checkIfBlackListId(int id) {
		BlackList blackList = blackListRepository.findById(id);
		if(blackList==null) {
			throw new BusinessException(Messages.BlackListNotUserId);
		}
	}
	private void checkIfBlackListExistByApplicantId(int applicantId) {
		Applicant applicant = applicantService.getByApplicantId(applicantId);
		if(applicant==null){
			throw new BusinessException(Messages.ApplicantIdNotFound);
		}
	}
	@Override
	public BlackList getByBlackList(int id) {
		BlackList blackList = this.blackListRepository.findById(id);
		return blackList;
	}
	private void checkIfBlackListExistByApplicant(int applicantId) {
		BlackList blackList = blackListRepository.findByApplicantId(applicantId);
		if(blackList!=null){
			throw new BusinessException(Messages.ApplicantIdNotFound);//hata yaz
		}
	}
	public void checkApplicantId(int ApplicantId) {
		 checkIfBlackListExistByApplicant(ApplicantId);
	}
	
}

