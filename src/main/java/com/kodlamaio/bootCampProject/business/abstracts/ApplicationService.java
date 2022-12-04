package com.kodlamaio.bootCampProject.business.abstracts;

import java.util.List;

import org.springframework.stereotype.Service;

import com.kodlamaio.bootCampProject.business.request.Application.CreateApplicationRequest;
import com.kodlamaio.bootCampProject.business.request.Application.UpdateApplicationRequest;
import com.kodlamaio.bootCampProject.business.response.Application.CreateApplicationResponse;
import com.kodlamaio.bootCampProject.business.response.Application.GetAllApplicationResponse;
import com.kodlamaio.bootCampProject.business.response.Application.GetApplicationResponse;
import com.kodlamaio.bootCampProject.business.response.Application.UpdateApplicationResponse;
import com.kodlamaio.bootCampProject.core.ultities.result.DataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.Result;

@Service
public interface ApplicationService {

	DataResult<CreateApplicationResponse> add(CreateApplicationRequest creatApplicationRequest);
	DataResult<UpdateApplicationResponse> update(UpdateApplicationRequest updateApplicationRequest);
	Result delete(int id);
	DataResult<GetApplicationResponse> getById(int id);
	DataResult<List<GetAllApplicationResponse>> getAll();
	
	
}
