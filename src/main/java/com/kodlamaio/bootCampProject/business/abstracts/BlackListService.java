package com.kodlamaio.bootCampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.bootCampProject.business.request.blackList.CreatBlackListRequest;
import com.kodlamaio.bootCampProject.business.request.blackList.UpdateBlackListRequest;
import com.kodlamaio.bootCampProject.business.response.blackList.CreateBlackListResponse;
import com.kodlamaio.bootCampProject.business.response.blackList.GetAllBlackListResponse;
import com.kodlamaio.bootCampProject.business.response.blackList.GetBlackListResponse;
import com.kodlamaio.bootCampProject.business.response.blackList.UpdateBlackListResponse;
import com.kodlamaio.bootCampProject.core.ultities.result.DataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.Result;
import com.kodlamaio.bootCampProject.entities.BlackList;

	public interface BlackListService {
	
	
	DataResult<CreateBlackListResponse> add(CreatBlackListRequest creatBlackListRequest);
	DataResult<UpdateBlackListResponse> update(UpdateBlackListRequest updateBlackListRequest);
	DataResult<List<GetAllBlackListResponse>> getAll();
	DataResult<GetBlackListResponse> getById(int id);
	Result delete(int id);
	BlackList getByBlackList(int id);
	void checkApplicantId(int ApplicantId);
	
	

}
