package com.kodlamaio.bootCampProject.business.abstracts;

import java.util.List;

import com.kodlamaio.bootCampProject.business.request.bootcamp.CreateBootcampRequest;
import com.kodlamaio.bootCampProject.business.request.bootcamp.UpdateBootcampRequest;
import com.kodlamaio.bootCampProject.business.response.bootcamp.CreateBootcampResponse;
import com.kodlamaio.bootCampProject.business.response.bootcamp.GetBootcampResponse;
import com.kodlamaio.bootCampProject.business.response.bootcamp.UpdateBootcampResponse;
import com.kodlamaio.bootCampProject.core.ultities.result.DataResult;
import com.kodlamaio.bootCampProject.core.ultities.result.Result;
import com.kodlamaio.bootCampProject.entities.Bootcamp;

public interface BootcampService {

	DataResult<CreateBootcampResponse> add(CreateBootcampRequest creatBootcampResquest);
	DataResult<UpdateBootcampResponse> update(UpdateBootcampRequest updateBootcampRequest);
	Result delete(int id);
	DataResult<GetBootcampResponse> getById(int id);
	DataResult<List<com.kodlamaio.bootCampProject.business.concrete.GetAllBootcampResponse>> getAll();
	Bootcamp getByBootcampId(int bootcampId);
	void checkIfApplicationExistState(int bootcampId);
}
